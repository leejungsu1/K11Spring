<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h2>스프링 MVC시작하기</h2>
	<!-- 
		Spring MVC에서는 이미지와 같은 리소스를 사용하기 위해
		별도로 resources폴더를 제공한다. 해당 폴더의 설정은
		servlet-context.xml에서 한다.
	 -->
	<h3>resources 폴더 사용하기</h3>
	<!-- 최초 설정으로 이미지 사용하기 -->
	<img src="./resources/4.png" alt="강아지" />
	<!-- <resources 엘리먼트의 mapping부분을 수정한 후 이미지 사용하기 -->
	<img src="./images/4.png" alt="강아지" />
	<!-- 
		리소스 사용을 위한 resources폴더의 기본 매핑명은 resources이지만
		엘리먼트 추가로 별칭을 변경하거나 추가할수있다.
	 -->
	 <h3>첫번째 컨트롤러 만들기</h3>
	 <!-- Step1 : 요청명을 결정한다. -->
	 <ul>
	 	<li>
	 		<a href="./home/helloSpring" target="_blank">
	 			첫번째 컨트롤러 바로가기
	 		</a>
	 	</li>
	 </ul>
	 
	 <!-- 컨트롤러 : FromController.java -->
	 <h3>form값 처리하기</h3>
	 <li>
	 	<a href="./form/servletRequest?id=kosmo&pw=1234" target="_blank">
	 		HttpServletRequest로 폼값받기
	 	</a>
	 </li>
	 
	 <li>
	 	<a href="./form/requestParam.do?id=kosmo&pw=1234&name=홍길동&email=hong@gildong.con" target="_blank">
	 		@requestParam어노테이션으로 폼값받기
	 	</a>
	 </li>
	 
	 <li>
	 	<a href="./form/commandObjGet.do?id=kosmo&pw=1234&name=홍길동&email=hong@gildong.con" target="_blank">
	 		커맨드(Command)객체로 한번에 폼값받기
	 	</a>
	 </li>

	 <li>
	 	<a href="./form/gildong99/코스모" target="_blank">
	 		pathVariable 어노테이션으로 폼값받기
	 	</a>
	 </li>
	 
	 <!-- 컨트롤러 : RequestMappingController.java -->
	 <h3>@RequestMapping 어노테이션 활용</h3>
	 
	 <li>
	 	<a href="./requestMapping/index.do" target="_blank">
	 		requestMapping 시작페이지 바로가기
	 	</a>
	 </li>
	 <h2>폼 데이터 검증하기 - Validator</h2>
	 
	 <!-- 컨트롤러 : ValidateController.java -->
	 <li>
	 	<a href="validate/memberRegist.do" target="_blank">
	 		회원가입 바로가기
	 	</a>
	 </li>
	 
	 <!-- 컨트롤러 : DIController.java -->
	 <h3>DI(Dependency Injection) : 의존성 주입</h3>
	 
	 <li>
	 	<a href="di/myCalculator" target="_blank">
	 		간단한 사칙연산 계산기
	 	</a>
	 </li>
	 <li>
	 	<a href="di/myBMICal" target="_blank">
	 		BMI(비만지수) 계산하기
	 	</a>
	 </li>
	 <li>
	 	<a href="di/myAvengers" target="_blank">
	 		어벤져스 히어로
	 	</a>
	 </li>
	 <li>
	 	<a href="di/myAnnotation" target="_blank">
	 		어노테이션을 이용한 DI활용
	 	</a>
	 </li>
	 
	 <!-- 컨트롤러 : EnvironmentController -->
	 <h3>Environment 객체를 이용한 외부파일 참조하기</h3>
	 <li>
	 	<a href="environment/main1" target="_blank">
	 		외부파일 참조하기 1 (Environment 객체 사용)
	 	</a>
	 </li>
	 <li>
	 	<a href="environment/main2" target="_blank">
	 		외부파일 참조하기 2 (XML설정파일 사용)
	 	</a>
	 </li>
	 <li>
	 	<a href="environment/main3" target="_blank">
	 		외부파일 참조하기 3 (어노테이션 사용)
	 	</a>
	 </li>
	 
</body>
</html>
