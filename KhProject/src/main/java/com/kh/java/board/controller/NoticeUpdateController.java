package com.kh.java.board.controller;

import java.io.File;
import java.io.IOException;

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

@WebServlet("/update.no")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//multiPart형식으로 요청이 잘 왔는가 확인
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getServletContext().getRealPath("/resources/notice_upfiles");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyRenamePolicy());
			
			// 값 뽑기
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			Long boardNo = Long.parseLong(multiRequest.getParameter("boardNo"));
			
			HttpSession session = request.getSession();
			
			Member member = (Member)session.getAttribute("userInfo");
			
			Board notice = new Board();
			
			notice.setBoardNo(boardNo);
			notice.setBoardTitle(boardTitle);
			notice.setBoardContent(boardContent);
			notice.setBoardWriter(String.valueOf(member.getUserNo()));
			
			Attachment at = null;
			
			if(multiRequest.getOriginalFileName("reUpfile")!=null) {
				at = new Attachment();
				
				at.setOriginName(multiRequest.getOriginalFileName("reUpfile"));
				at.setChangeName(multiRequest.getFilesystemName("reUpfile"));
				at.setFilePath("resources/notice_upfiles");
				
				if(multiRequest.getParameter("fileNo") !=null) {
					//새로운 첨부파일 + 원본파일 존재
					at.setFileNo(Long.parseLong(multiRequest.getParameter("fileNo")));
					
					new File(savePath + "/" + multiRequest.getParameter("changeName")).delete();
				} else {
					// 새로운 첨부파일 + 원본파일 X
					at.setRefBno(boardNo);
				}
			}
			
			int result = new BoardService().update(notice, at);
			
			if(result > 0) {
				session.setAttribute("alertMsg","수정 성공");
				
				response.sendRedirect(request.getContextPath()+"/detail.no?boardNo="+boardNo);
			} else {
				request.setAttribute("msg", "수정에 실패했습니다.");
				
				request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
			}
			
			
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
