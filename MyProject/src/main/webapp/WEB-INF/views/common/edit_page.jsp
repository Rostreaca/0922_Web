<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#editInfo{
		padding-top: 100px;
		margin: auto;
		width:600px;
		height:600px;
	}

</style>

</head>
<body>
	
	
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	
<div id="editInfo">
<form action="#" method="post">
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">아이디</span>
  <input type="text" class="form-control" placeholder="UserID" aria-label="UserID" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">비밀번호</span>
  <input type="text" class="form-control" placeholder="Password" aria-label="PASSWORD" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">이름</span>
  <input type="text" class="form-control" placeholder="UserName" aria-label="UserName" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <input type="text" class="form-control" placeholder="이메일" aria-label="Username">
</div>
  <input class="btn btn-outline-primary" type="submit" value="변경">
</form>


</div>
	
	
</body>
</html>