package com.kh.java.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;
import com.kh.java.common.MyRenamePolicy;
import com.kh.java.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/insert.no")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			
			int maxSize = 10 * 1024 * 1024;
			
			HttpSession session = request.getSession();
			ServletContext application = session.getServletContext();
			String savePath = application.getRealPath("/resources/notice_upfiles");
			
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8", new MyRenamePolicy());
			
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			Long userNo = ((Member)session.getAttribute("userInfo")).getUserNo();
			
			Board notice = new Board();
			notice.setBoardTitle(title);
			notice.setBoardContent(content);
			notice.setBoardWriter(String.valueOf(userNo));
			

			System.out.println(notice);
			
			Attachment at = null;
			
			if(multiRequest.getOriginalFileName("upfile")!=null) {
				
				at = new Attachment();
				
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				
				at.setFilePath("resources/notice_upfiles");
			}
			
			int result = new BoardService().insertNotice(notice, at);
			
			if(result > 0) {
				
				session.setAttribute("alertMsg", "게시글 작성 성공~");
				
				response.sendRedirect(request.getContextPath()+"/notice?page=1");
			} else {
				if(at != null) {
					new File(savePath + "/" + at.getChangeName()).delete();
				}
					request.setAttribute("msg", "게시글 작성 실패 ㅠ");
					request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
				}
				
			}
			
			
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
