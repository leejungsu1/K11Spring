<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main1.jsp</title>
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
	<h2>Environment 객체를 이용한 외부파일 사용하기</h2>
	<h3>EnvAdmin.properties파일에서 읽어온 Oracle의 kosmo계정 정보</h3>
	
	<ul>
		<li>아이디 : ${adminID }</li>	
		<li>패스워드 : ${adminPW }</li>
	</ul>

</div>
</body>
</html>