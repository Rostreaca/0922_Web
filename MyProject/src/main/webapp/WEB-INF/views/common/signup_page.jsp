<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#wrap{
		width: 700px;
		height: 600px;
		border-radius : 27px;
		background-color : white;
		padding: 30px;
		margin : auto;
		margin-top : 50px;
		text-align: center;
	}
	#signInfo{
		margin:auto;
		justify-content: center;
	}
	#signIn-table{
		width: 80%;
	}
	tr{
		height: 100px;
	}
	
</style>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body id="page-top" class="bg-info-subtle">

	
	<jsp:include page="/WEB-INF/views/include/header.jsp" />

	<div id="wrap">
	<h1>회원가입 페이지</h1>
	
		<div id="signInfo">
			<table id="signIn-table">
			<form action="/mp" method="post">
			<tr>
				  <th>아이디</th>
				 <td><input class="form-control" type="text" name="userId" maxlength="15" placeholder="15자 이내로 입력해주세요"></td>
			</tr>
			<tr>
				  <th>비밀번호</th>
				  <td><input class="form-control" type="password" name="userPwd" maxlength="20" placeholder="20자 이내로 입력해주세요"/></td>
			</tr>
			<tr>
				  <th>이름</th>
				  <td><input class="form-control" type="text" name="userName" maxlength="10"></td>
			</tr>
			<tr>
				  <th>이메일</th>
				  <td><input class="form-control" type="text" name="email"></td>
			</tr>
				<tr>
				  <th></th>
				  <td colspan="5"><input class="btn btn-primary" type="submit" value="회원가입" style="width: 100%;"/></td>
				</tr>
			</form>
			</table>
		</div>	
	
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>	
</body>
</html>