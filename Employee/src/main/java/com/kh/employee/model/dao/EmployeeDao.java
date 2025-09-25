package com.kh.employee.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.employee.model.vo.Employee;

public class EmployeeDao {

	public List<Employee> findAll(SqlSession session){
		return session.selectList("employeeMapper.findAll");
	}

	public int insertEmployee(SqlSession session, Employee employee) {
		return session.insert("employeeMapper.insertEmployee",employee);
	}
}
