<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&display=swap" rel="stylesheet">

<link href="resources/css/agency.min.css" rel="stylesheet">
<style>
td > input{
	width:100%;

}

#login-btn {

	&:hover{
		cursor:pointer;
	}
}

#loginHeader{
	align-items: center;
	background-color: yellowgreen;
}

#login-table{
	text-align: center;
	width: 400px;
}


.modal-body{
	margin: 20px;
	align-content: center;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body id="page-top">

<nav class="navbar navbar-expand-lg bg-body-tertiary bg-info-subtle text-info-emphasis">
  <div class="container-fluid">
    <a class="navbar-brand" href="/mp">KHCOMPUTER</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/mp">Home</a>
        </li>
        <c:choose>
        <c:when test="${ empty sessionScope.userInfo }">
        <li class="nav-item">
          <a id="login-btn" class="nav-link js-scroll-trigger" data-bs-toggle="modal" data-bs-target="#exampleModal">로그인</a>
          
        </li>
         <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="/mp/signup">회원가입</a>
        </li> 
        </c:when>
        <c:otherwise>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="/mp/edit">정보수정</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="#">로그아웃</a>
        </li>
        </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>
</nav>

<!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header"  id="loginHeader">
        <h1 class="modal-title fs-5">로그인 정보 입력</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      	<table id="login-table">
      	<form action="login" method="post">
      	<tr>
      	<th>아이디</th>
      	<td><input type="text" name="userId" required="required" maxlength="15"/></td>
      	</tr>
      	<tr style="padding:30px">
      	<th>비밀번호</th>
      	<td><input type="password" name="userPwd" required="required" maxlength="20"/></td>
      	</tr>
      		<td colspan="3" style="padding-top: 40px"><input class="btn btn-primary" type="submit" value="로그인"/></td>
      	</tr>
      	</form>
      	</table>
      </div>
      </div>
    </div>
  </div>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>