<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberRegist.jsp</title>
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

	<h2>Validate 인터페이스를 구현한 폼값 검증</h2>
	<!-- Validator를 통해 폼값 검증후 에러가 있는 경우 출력 -->
	<span style="color: red; font-size: 1.5em;">${formError }</span>
	
	<script type="text/javascript">
		function registCheck(){
			//스프링에서 제공하는 클래스를 통해 검증하기 때문에 구색만 맞춤...
		}
	</script>
	<form action="./registProc" method="post" name="registFrm" onsubmit="return registCheck();">
		<table class="table table-bordered" style="width: 500px;">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"  value="${mInfo.id }"/></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pw"  value="${mInfo.pw }"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"  value="${mInfo.name }"/></td>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<button type="submit">회원가입하기</button>
				</td> 
			</tr>
		</table>
	</form>
	
	
	
	
</div>
</body>
</html>