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
<form action="update.me" method="post">
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">아이디</span>
  <input type="text" name="userId" class="form-control" value="${ userInfo.userId }" aria-label="UserID" aria-describedby="basic-addon1" readonly="readonly">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">이름</span>
  <input type="text" name="userName" class="form-control" value="${ userInfo.userName }" placeholder="UserName" aria-label="UserName" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">이메일</span>
  <input type="text" name="email" class="form-control" value="${ userInfo.email }" placeholder="Email" aria-label="Email" aria-describedby="basic-addon1">
</div>

  <input class="btn btn-outline-primary" type="submit" value="회원정보 변경"/>
  <input type="button" class="btn btn-outline-warning" value="비밀번호 변경" data-bs-toggle="modal" data-bs-target="#updatePwd"/>
  <input class="btn btn-primary" type="button" value="회원 탈퇴" data-bs-toggle="modal" data-bs-target="#deleteForm"/>
</form>

<!-- 회원 탈퇴 모달 -->
	<div class="modal" id="deleteForm">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <div class="modal-header">
	        <h4 class="modal-title" style="color:red;">회원 탈퇴</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <div class="modal-body">
	        <form action="delete.me" method="post">
	        
			  <div class="form-group">
			    <label for="userPwd" style="font-size:12px; color:red">탈퇴를 원하신다면 비밀번호를 입력해주세요.</label>
			    <input type="password" name="userPwd" class="form-control" placeholder="비밀번호를 입력해주세요." id="deletePwd" required>
			  </div>
			  
			  <button type="submit" class="btn btn-danger" onclick="return deleteMember();">회원탈퇴</button>
			  
			  <script>
			  	function deleteMember(){
			  		
			  		const value = prompt('탈퇴를 원하신다면 "어쩌고저쩌고"를 정확히 입력해주세요.');
			  		
			  		if(value === '어쩌고저쩌고'){
						return true;	  			
			  		}
			  		else{
			  			return false;
			  		}
			  		
			  	}
			  </script>
			</form>
	      </div>

	
	    </div>
	  </div>
	</div>


</div>
	
<div class="modal" id="updatePwd">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <div class="modal-header">
	        <h4 class="modal-title">비밀번호 변경</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	
	      <div class="modal-body">
	        <form action="updatePwd.me" method="post">
	        
			  <div class="form-group">
			    <label for="userPwd">현재 비밀번호 :</label>
			    <input type="password" name="userPwd" class="form-control" placeholder="비밀번호를 입력해주세요." id="userPwd" required>
			  </div>
			  
			  <div class="form-group">
			    <label for="changePwd">변경할 비밀번호 :</label>
			    <input type="password" name="changePwd" class="form-control" placeholder="변경할 비밀번호를 입력해주세요." id="changePwd" required>
			  </div>
			  
			  <div class="form-group">
			    <label for="checkPwd">변경할 비밀번호 확인 :</label>
			    <input type="password" class="form-control" placeholder="다시 한 번 입력해주세요." id="checkPwd" required>
			  </div>
			  
			  <button type="submit" class="btn btn-secondary" onclick="return validatePwd();">비밀번호 변경</button>
			  
			  <script>
			  	function validatePwd(){
			  		
			  		if($('#changePwd').val() != $('#checkPwd').val()){
			  			alert('비밀번호를 동일하게 입력해주세요!');
			  			$('#checkPwd').focus().val('');
			  			return false;
			  		}
			  		
			  		return true;
			  	}
			  </script>
			</form>
	      </div>

	
	    </div>
	  </div>
	</div>
	
</body>
</html>