package com.kh.java.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Board;
import com.kh.java.common.vo.PageInfo;

@WebServlet("/notice")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		pageLimit = 5;
		boardLimit = 5;
		
		listCount = new BoardService().selectNoticeCount();
		currentPage =  Integer.parseInt(request.getParameter("page"));
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage -1 )/ pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		endPage = endPage > maxPage ? maxPage : endPage;
		
		int offset = (currentPage -1 ) * boardLimit;
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, startPage, endPage, maxPage, offset);
		
		List<Board> notice = new BoardService().selectNoticeList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("notice", notice);
		
		request.getRequestDispatcher("/WEB-INF/views/notice/notice_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
