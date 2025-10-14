package com.kh.java.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Board;
import com.kh.java.member.model.vo.Member;

@WebServlet("/delete.no")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long boardNo = Long.parseLong(request.getParameter("boardNo"));
		HttpSession session = request.getSession();
		Long userNo = ((Member)session.getAttribute("userInfo")).getUserNo();
		
		Board notice = new Board();
		
		notice.setBoardNo(boardNo);
		notice.setBoardWriter(String.valueOf(userNo));
		
		int result = new BoardService().deleteBoard(notice);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "게시글 삭제 성공");
			
			response.sendRedirect(request.getContextPath()+"/notice?page=1");
		} else {
			session.setAttribute("alertMsg", "삭제 실패");
			
			response.sendRedirect(request.getContextPath()+"/detail.no?boardNo="+boardNo);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
