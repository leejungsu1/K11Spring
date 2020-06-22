package com.kosmo.k11spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import di.CalculatorDTO;

@Controller
public class DIController {
	
	//DI를 이용한 간단한 사칙연산 계산기 만들기
	@RequestMapping("di/myCalculator")
	public String myCal(Model model) {
		/*
		ApplicationContext 파일의 위치를 문자열에 저장한다.
		물리적 경로는 src/main/resources디렉토리 하위임.
		※webapp하위의 resources 디렉토리는 이미지나 js파일 등
			리소스를 저장하는 곳이므로 혼동하지 않도록 주의
		 */
		String configLocation = "classpath:DIAppCtxCalculator.xml";
		/*
		스프링 컨테이너 생성 : xml파일을 파싱하여 파싱된 내용을 기반으로
			ctx참조변수를 생성한다.
		 */
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		/*
		XML설정파일에서 생성한 빈(Bean)을 getBean()을 통해 주입받아
		참조변수에 할당한다. new연산자를 통해 생성한 것과 동일하지만
		외부설정파일에서 미리 생성한것을 주입(Injection)받은 것임에 
		유의할것
		 */
		CalculatorDTO myCal = ctx.getBean("myCal", CalculatorDTO.class);
		
		/*
		주입받은 빈을 통해 사칙연산을 진행하고, 결과값을 model객체에
		저장한다. 해당 결과는 View로 전송한다.
		 */
		model.addAttribute("addResult", myCal.add());
		model.addAttribute("subResult", myCal.sub());
		model.addAttribute("mulResult", myCal.mul());
		model.addAttribute("divResult", myCal.div());
		
		return "04DI/myCalculator";
	}
	
}
