package com.kh.subway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.subway.model.service.SubwayService;
import com.kh.subway.model.vo.Subway;

@WebServlet("/orderList.sandwich")
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public OrderListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0) GET? POST ?
		// a태그 요청 == 100% GET방식
		
		// 요청 시 전달값이 있는가?
		
		// 1) 데이터 가공 => X
		
		// 2) 요청처리 -> Service단 호출
		List<Subway> orderList = new SubwayService().findAll();
		
//		System.out.println(orderList);
		
		request.setAttribute("orders", orderList);
		
		// 조회결과가 있을 수도 있음 / 없을 수도 있음
		
		request.getRequestDispatcher("/views/list.jsp").forward(request, response);
		// 용도가 한 가지인 경우 변수에 담지 않음
		
		// 숙제 Subway 프로젝트를 참고해서
		// Employee 프로젝트를 만들고
		// index.jsp를 만들어서 INSERT랑
		// SELECT해보기
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
