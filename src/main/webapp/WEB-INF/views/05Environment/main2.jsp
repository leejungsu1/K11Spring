<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main2.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script>
$(function(){
	
});
</script>
</head>
<body>
<div class="container">
	<h2>XML파일에 프로퍼티 파일을 명시한 후 외부 파일 읽어오기</h2>

	<h3>메인 관리자 정보</h3>

	 <ul>
	 	<li>아이디 : ${mainUserId }</li>
	 	<li>패스워드 : ${mainUserPw }</li>
	 </ul>
	
	<h3>서브 관리자 정보</h3>

	 <ul>
	 	<li>아이디 : ${subUserId }</li>
	 	<li>패스워드 : ${subUserPw }</li>
	 </ul>
</div>
</body>
</html>