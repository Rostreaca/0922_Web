package com.kh.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

@WebServlet("/update.me")
public class UpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String userId = ((Member)request.getSession().getAttribute("userInfo")).getUserId();
		String userPwd = ((Member)request.getSession().getAttribute("userInfo")).getUserPwd();
		int userNo = ((Member)request.getSession().getAttribute("userInfo")).getUserNo();
		
		Member member = new Member();
		
		member.setUserName(userName);
		member.setEmail(email);
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		member.setUserNo(userNo);
		
		Member updateMember = new MemberService().update(member);
		
		if(updateMember != null) {
			response.sendRedirect(request.getContextPath()+"/edit");
			
		} else {
			request.setAttribute("msg", "정보 변경에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
