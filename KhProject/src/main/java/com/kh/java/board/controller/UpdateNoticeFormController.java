package com.kh.java.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;

@WebServlet("/updateForm.no")
public class UpdateNoticeFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateNoticeFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		Map<String, Object> map = new BoardService().selectNotice(boardNo);
		
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("/WEB-INF/views/notice/update_form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
