package com.kh.employee.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.employee.common.Template;
import com.kh.employee.model.dao.EmployeeDao;
import com.kh.employee.model.vo.Employee;

public class EmployeeService {
	
	private EmployeeDao ed = new EmployeeDao();
	
	public List<Employee> findAll(){
		
		SqlSession session = Template.getSqlSession();
		
		List<Employee> employees = ed.findAll(session);
		
		session.close();
		
		return employees;
	}

}
