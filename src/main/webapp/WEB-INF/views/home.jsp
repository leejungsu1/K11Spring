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
<!-- 
DI를 활용한 개발 순서
1. 요청명을 결정한다.
	-> di/myCalculator
2. 컨트롤러를 생성한 후 해당 요청명을 매핑한 메소드 정의
	-> @RequestMapping("di/myCalculator")
	public String 메소드명(){
		수행할 내용;
	}
3. View에 해당하는 jsp파일을 생성한다.
4. 해당 프로그램에서 사용할 클래스 생성
	-> src/main/java 아래 패키지 생성후 클래스를 추가함.
5. XML 설정파일을 생성한 후 <bean> 엘리먼트를 통해 빈 생성
	-> src/main/resources 하위에 Spring Bean Configuration File
	을 생성함
6. View로 전달할 정보를 model객체에 저장한 후 호출
	->String 혹은 ModelAndView객체를 사용함
 -->
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
	 
	 <h3>파일업로드</h3>
	 
	 <li>
	 	<a href="./fileUpload/uploadPath.do" target="_blank">
	 		upload폴더의 물리적 경로 확인하기
	 	</a>
	 </li>
	 <li>
	 	<a href="./fileUpload/uploadForm.do" target="_blank">
	 		파일업로드 폼
	 	</a>
	 </li>
	 <li>
	 	<a href="./fileUpload/uploadList.do" target="_blank">
	 		파일목록보기
	 	</a>
	 </li>
	 
</body>
</html>
