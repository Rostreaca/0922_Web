<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
<style>
	form {
		width : 90%;
		margin : auto;
	}

</style>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	
	<c:if test="${ userInfo eq null }">
		<script>
			alert("글 작성은 로그인 시에만 가능합니다.");
			location.href='/kh';
		</script>
	</c:if>


	<div class="outer">

        <h2 align="center">공지사항 작성하기</h2>
        <br><br> 
		
        <form action="insert.no" method="post" id="insert-form"
        	  enctype="multipart/form-data">

            <div class="form-group">
                <label for="usr">제목</label>
                <input type="text" class="form-control" id="usr" name="title" required="required">
            </div>

            <div class="form-group">
                <label for="comment">내용</label>
                <textarea class="form-control" name="content" rows="15" id="comment" style="resize:none;" required="required"></textarea>
            </div>
            
            <div class="form-group">
            	<input type="file" name="upfile">
            </div>

            <div align="center">
                <button type="submit" class="btn btn-sm btn-info">등록하기</button>
                <button type="button" class="btn btn-sm btn-secondary"
                onclick="history.back();">뒤로가기</button>
            </div>

        </form>
        
    </div>
    
    <jsp:include page="../include/footer.jsp" />

</body>
</html>