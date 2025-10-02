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

@WebServlet("/delete.me")
public class DeleteMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteMemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		
		String userPwd = request.getParameter("userPwd");
		int userNo = ((Member)session.getAttribute("userInfo")).getUserNo();
		
		Map<String, String> map = Map.of("userPwd", userPwd, "userNo", String.valueOf(userNo));
		
		int result = new MemberService().delete(map);
		
		if(result > 0){
			session.removeAttribute("userInfo");
			session.setAttribute("alertMsg", "회원이 성공적으로 삭제되었습니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("msg", "회원 삭제 실패.");
			request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
