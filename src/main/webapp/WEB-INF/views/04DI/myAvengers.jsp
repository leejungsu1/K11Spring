<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myAvengers.jsp</title>
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

	<h2>DI를 활용한 어벤져스 히어로</h2>	
	<h3>생성자를 사용하요 빈 생성하기</h3>
	<h4>캡틴 아메리카 정보</h4>

	<li>
		${captainAmerica }
	</li>
	<h4>아이언맨 정보</h4>

	<li>
		${ironMan }
	</li>
	


</div>
</body>
</html>