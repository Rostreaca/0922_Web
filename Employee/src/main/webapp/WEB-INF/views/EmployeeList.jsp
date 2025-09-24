<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List, com.kh.employee.model.vo.Employee" %>
<%
	List<Employee> emp = (List<Employee>)request.getAttribute("employees");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, tr, td, th{
		border: 1px solid grey;
	}
</style>
</head>
<body>
	<h1>사원 정보</h1>
	
	<table>
		<tr>
			<th>사원번호</th>
			<th>직원명</th>
			<th>주민등록번호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>부서코드</th>
			<th>직급코드</th>
			<th>급여등급</th>
			<th>급여</th>
			<th>보너스율</th>
			<th>관리자사번</th>
			<th>입사일</th>
		</tr>
		
		<% if(emp.isEmpty()) { %>
			<tr>
				<th colspan="10"> 조회결과가 존재하지 않습니다.
			</tr>
		<% } else { %>
			<tr>
			<% for(Employee e : emp) { %>
				<td><%= e.getEmpId() %></td>
				<td><%= e.getEmpName() %></td>
				<td><%= e.getEmpNo() %></td>
				<td><%= e.getEmail() %></td>
				<td><%= e.getPhone() %></td>
				<td><%= e.getDeptCode() %></td>
				<td><%= e.getJobCode() %></td>
				<td><%= e.getSalLevel() %></td>
				<td><%= e.getSalary() %></td>
				<td><%= e.getBonus() %></td>
				<td><%= e.getManagerId() %></td>
				<td><%= e.getHireDate() %></td>
			</tr>
			<% } %>
		<% } %>
	</table>
	
</body>
</html>