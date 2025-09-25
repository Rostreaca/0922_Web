package com.kh.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.employee.model.service.EmployeeService;
import com.kh.employee.model.vo.Employee;

@WebServlet("/insertEmp.do")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddEmployeeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empName = request.getParameter("empName");
		String empNo = request.getParameter("empNo");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone"); 
		String department = request.getParameter("department");
		String job = request.getParameter("job");
		String salLevel = request.getParameter("salLevel");
		int salary = Integer.parseInt(request.getParameter("salary"));
		double bonus =Double.parseDouble(request.getParameter("bonus"));
		String managerId = request.getParameter("managerId");
		
		Employee employee = new Employee();
		
		employee.setEmpName(empName);
		employee.setEmpNo(empNo);
		employee.setEmail(email);
		employee.setPhone(phone);
		employee.setDeptCode(department);
		employee.setJobCode(job);
		employee.setSalLevel(salLevel);
		employee.setSalary(salary);
		employee.setBonus(bonus);
		employee.setManagerId(managerId);
		
		int result = new EmployeeService().insertEmployee(employee);
		
		if(result > 0) {
			
			request.setAttribute("employee", employee);
			
			request.getRequestDispatcher("/WEB-INF/views/AddEmployee.jsp").forward(request, response);
			
		} else {
			response.getWriter().append("실패");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
