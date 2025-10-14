<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 페이지</title>
<style>
#div_list {
	width: 1200px;
	height: 800px;
	margin: auto;
	margin-top: 50px;
}
table {
	margin: auto;
}
thead>*, #noticeList>*>*{
	border : 1px solid black;
	text-align: center;
	
}

.board:hover{
	cursor:pointer;
	background-color: lightgrey;
}
</style>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<div id="div_list">
		<h2 style="font-size: 33px; color: orange; text-align: center;">공지사항
			<a href="enrollForm.no" class="btn float-right" style="border: 1px solid violet;">글쓰기</a>
		</h2>
		<table style="border : 1px solid black;">
			<thead style="border : 1px solid black;">
				<tr>
					<th width="100">번호</th>
					<th width="150">작성자</th>
					<th width="400">제목</th>
					<th width="200">작성일</th>
					<th width="100">조회수</th>
				</tr>
			</thead>
			<tbody id="noticeList">
			<c:forEach var="notice" items="${ notice }">
				<tr class="board" id=${ notice.boardNo }>
					<td>${ notice.boardNo }</td>
					<td>${ notice.boardWriter }</td>
					<td>${ notice.boardTitle }</td>
					<td>${ notice.createDate }</td>
					<td>${ notice.count }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div id="search-area" class="form-group">
					<form action="search.no" method="get">
						<select name="condition" class="form-control">
							<option value="writer">작성자</option>
							<option value="content">내용</option>
							<option value="title">제목</option>
						</select>
						<input type="text" name="query" class="form-control" value="${ keyword }"/>
						<input type="hidden" name="page" value="1" />
						<button type="submit" class="btn btn-block" style="background:#52b1ff; color:white">검색</button>
					</form>
			    </div>
		<c:if test="${ not empty condition  }">
			<script>
				$('#search-area option[value=${condition}]').attr('selected',true);
			</script>
		</c:if>
		
		<script>
			$(function(){
				$('.board').click(e => {
					const targetId = e.currentTarget.id;
					location.href = `detail.no?boardNo=\${targetId}`;
				});
			});
		</script>
		
		
		<div class="paging-area" align="center">
		
		<c:if test="${ pi.currentPage > 1 }"> 
		<c:choose>
		<c:when test="${ not empty condition }">
			<button class="btn btn-outline-primary" onclick="location.href='search.no?page=${pi.currentPage-1}&condition=${ condition }&query=${ keyword }'" >이전</button>
		</c:when>
		<c:otherwise>
			<button class="btn btn-outline-primary" onclick="location.href='notice?page=${pi.currentPage-1}'">이전</button>
		</c:otherwise>
		</c:choose>
		</c:if>	
		<c:forEach var="i" begin="${ pi.startPage }" end="${ pi.endPage }">
			<button class="btn btn-outline-primary" onclick="location.href='notice?page=${i}'">${i}</button>
		</c:forEach>
			
		<c:if test="${ pi.currentPage ne pi.maxPage }">
			<button class="btn btn-outline-primary" onclick="location.href='notice?page=${pi.currentPage+1}'">다음</button>
		</c:if>
		</div>
		
		
		
	</div>



</body>
</html>