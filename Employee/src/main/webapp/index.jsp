<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

<!--1. Servers의 Tomcat클릭해서 Runtime Environment 클릭-> browse로 톰캣 경로 변경바람.
	2. 프로젝트의 properties - > project facets에서 dynamic web project -> runtime에서 tomcat 체크
 -->

<style>
	
	body{
		background-color : black;
		color : white;
	}
	
	#wrap{
		width : 1000px;
		height : 1200px;
		margin : auto;
	}
	
	#title{
		text-align : center;
		color : grey;
		font-size : 44px;
	}
	
	.content{
		background-color : darkgrey;
		border-radius : 20px;
		margin: auto;
		padding: 15px;
	}
	table {
		border-collapse: separate;
		border-spacing: 0 5px;
	}
	
	legend {
		text-align : center;
	}

</style>

</head>
<body>
<h1>사원 정보 입력</h1>

	<div id="wrap">
		<div id="header">
			<h1 id="title">사원 추가 페이지</h1>
		</div>
		
		<div class="content">
			<br><br>
				<form action="insertEmp.do" method="get">
			
					<fieldset>
						<legend>사원 개인 정보</legend>
							이름  <input type="text" name="empName" class="form-control">
							주민번호  <input type="text" name="empNo" class="form-control">
							이메일  <input type="text" name="email" class="form-control">
							전화번호 <input type="text" name="phone" class="form-control">
							
					</fieldset>
					<br><br>
					<fieldset>
						<legend>사원 부서 정보</legend>
							<table>
								<tr>
									<th width=55px>부서</th>
									<td>
							 		<input type="radio" name="department" value="인사관리부">인사관리부
							 		<input type="radio" name="department" value="회계관리부">회계관리부
							 		<input type="radio" name="department" value="마케팅부">마케팅부
							 		<input type="radio" name="department" value="국내영업부">국내영업부
							 		<input type="radio" name="department" value="회계관리부">회계관리부
							 		<input type="radio" name="department" value="해외영업1부">해외영업1부
							 		<input type="radio" name="department" value="해외영업2부">해외영업2부
							 		<input type="radio" name="department" value="해외영업3부">해외영업3부<br>
							 		<input type="radio" name="department" value="기술지원부">기술지원부
							 		<input type="radio" name="department" value="총무부">총무부
							 		</td>
								</tr>
							<tr>
							<th>직급</th>
								<td>
									<select name="job" class="form-control">
										<option>대표</option>
										<option>부사장</option>
										<option>부장</option>
										<option>차장</option>
										<option>과장</option>
										<option>대리</option>
										<option>사원</option>
										<option>인턴</option>
									</select>
								</td>
							</tr>
							<tr>
							<th>월급</th>
							<td>
								<input type="number" name="salary" class="form-control" value=0>
							</td>
							</tr>
							<tr>
							<th>급여등급</th>
							<td>
								<input type="text" name="salLevel" class="form-control" value="s1"><br>
							</td>
							</tr>
							<tr>
							<th>보너스</th>
							<td>
								<input type="number" name="bonus" class="form-control" value=0>
							</td>
							</tr>
							<tr>
							<th>사수정보</th>
							<td>
								<input type="text" name="managerId" class="form-control">
							</td>
							</tr>
							
							</table>
					</fieldset>
			
					<br><br>
					<input type="submit" value="추가" class="btn btn-primary"/>
					<input type="reset" value="초기화" class="btn btn-warning"/>
					<a href="/Employee/selectEmp.do">사원정보조회</a>
					
				</form>
		
		</div>
		
		
	</div>
	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>