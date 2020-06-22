package com.kosmo.k11spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import common.MemberDTO;
import common.MemberValidator;

@Controller
public class ValidateController {
	//회원가입페이지 매핑하기
	@RequestMapping("validate/memberRegist.do")
	public String memberRegist() {
		
		return "03Validate/memberRegist";
	}
	//회원가입페이지의 폼값을 전송받아 검증하는 메소드
	@RequestMapping("/validate/registProc")
	public String registProc(@ModelAttribute("mInfo") MemberDTO memberDTO,
								BindingResult result, Model model) {
		/*
		BindingResult객체 : validator를 통해 폼값을 검증한후
			해당 결과를 전송받을 객체 폼값에 문제가 있다면
			해당 객체를 통해 확인할수있다.
		 */
		
		//폼값 검증 완료시 이동할 페이지의 경로(요청명)
		String viewPage = "03Validate/memberDone";
		
		/*
		유효성 검증을 위해 정의한 클래스의 객체를 생성한 후
		전송된 폼값을 저장한 커맨드객체를 통해 폼값의 유효성 체크를
		실시한다.
		매개변수로 유효성체크를 할 커맨드 객체와 바인딩 결과(검증결과)를
		저장할 객체를 전달한다.
		 */
		MemberValidator validator = new MemberValidator();
		validator.validate(memberDTO, result);
		
		if(result.hasErrors()) {
			System.out.println("유효성 체크 실패 : "+result.toString());
			//검증실패의 경우 model영역에 에러메세지를 저장한 후
			model.addAttribute("formError", "폼값 유효성 체크에 실패하였습니다.");
			//가입페이지로 다시 돌아간다.
			viewPage = "03Validate/memberRegist";
		}
		return viewPage;
	}
}
