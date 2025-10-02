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

/**
 * Servlet implementation class UpdatePwdController
 */
@WebServlet("/updatePwd.me")
public class UpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePwdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userPwd = request.getParameter("userPwd");
		String changePwd = request.getParameter("changePwd");
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("userInfo");
		int userNo = member.getUserNo();
		
		Map<String, String> map = Map.of("userPwd", userPwd, "changePwd",changePwd, "userNo", String.valueOf(userNo));
		
		int result = new MemberService().updatePwd(map);
		
		if(result > 0) {
			member.setUserPwd(changePwd);
		}
		
		session.setAttribute("alertMsg", result > 0 ? "비밀번호 변경성공" : "비밀번호 변경실패");
		response.sendRedirect(request.getContextPath()+"/edit");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
