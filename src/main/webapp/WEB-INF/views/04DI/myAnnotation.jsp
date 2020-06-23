<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myAnnotation.jsp</title>
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
	
	<h2>어노테이션을 통해 JAVA파일에서 DI 사용하기</h2>
	
	<ul>
		<li>홍길동 회원님 정보 : </li>
		<li>${memberInfo1 }</li>
	</ul>
	<ul>
		<li>[이정수] 회원님 정보 :</li>
		<li>${memberInfo2 }</li>
	</ul>
	
</div>
</body>
</html>