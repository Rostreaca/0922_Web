<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

#div_form{
	weight:1200px;
	height:800px;
	margin:auto;
	text-align: center;
	margin-top: 150px;
}
._button{
	display:flex;
	justify-content: center;
}
#boardTable{
	margin : auto;
	border : 1px solid black;
	margin-bottom: 30px;
}
</style>

</head>
<body>
<jsp:include page="../include/header.jsp"/>

<div id="div_form">
	
<table id="boardTable">
	<tr>
		<th width="100">번호</th>
		<th width="150">카테고리</th>
		<th width="150">작성자</th>
		<th width="400">제목</th>
		<th width="200">작성일</th>
		<th width="100">조회수</th>
	</tr>
	<tr>
		<td>999</td>
		<td>a</td>
		<td>테스트</td>
		<td>공갈입니다</td>
		<td>2025-10-11</td>
		<td>9999</td>
	</tr>
</table>

<div class="_button">
<button>이전</button>
<button>1</button>
<button>다음</button>
</div>
</div>


<jsp:include page="../include/footer.jsp"/>
</body>
</html>