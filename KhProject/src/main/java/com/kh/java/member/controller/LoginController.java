package com.kh.java.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.Member;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * <HttpServletRequest, HttpServletResponse>
		 * 
		 * - request : 서버로 요청 보낼 때의 정보(요청 시 전달값, 요청 전송방식, 사용자정보) 
		 * - response : 요청에 대한 응답데이터를 만들 때 사용
		 */
		// 절차
		// 1) GET? POST? => 요청 방식이 POST방식이라면 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 시 전달값이 있나? 없나? => POST는 무조건 해야함
		// request.getParameter("키값") : String
		// request.getParameter("키값") : String[]
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println(userId);
		System.out.println(userPwd);
		
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		// 3) 그러면 이제 뭐 해야할까요?(요청 처리)
		Member loginMember = new MemberService().login(member);
		// 성공했을 경우 : 조회성공한 컬럼값을 필드에 담은 멤버객체 주소값
		// 실패했을 경우 : null값
//		System.out.println(loginMember);
		
		// 4) 응답화면 지정
		// 스텝 1. request속성에 출력할 값 추가 => setAttribute()
		// 스텝 2. RequestDispatcher => 뷰 지정
		// 스텝 3. RequestDispatcher이용해서 forward()호출
		
		// 실패했다!
		request.setAttribute("msg", "로그인에 실패했습니다.");
		request.getRequestDispatcher("");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
