package com.kosmo.k11spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import common.StudentDTO;

@Controller
public class RequestMappingController {

	@RequestMapping("requestMapping/index.do")
	public String rmIndex() {
		
		return "02RequestMapping/index";
	}
	/*
	단순히 요청명만 매핑하는 경우에는 value, method를 제외할수있으나
	전송방식까지 명시해야 하는 경우에는 속성을 제거하면 에러가
	발생된다.
	 */
	@RequestMapping(value="/requestMapping/getSearch.do", method=RequestMethod.GET)
	public String getSearch(HttpServletRequest req, Model model) {
		
		System.out.println("RequestMethod.GET방식으로"+"폼값전송");
		
		//request객체를 통해 폼값을 받음
		String sColumn = req.getParameter("searchColumn");
		String sWord = req.getParameter("searchWord");
		
		//모델객체에 데이터 저장
		model.addAttribute("sColumn", sColumn);
		model.addAttribute("sWord", sWord);
		
		//뷰 호출
		return "02RequestMapping/getSearch";
	}
	
	/*
	ModelAndView객체
		 : View로 전송할 데이터의 저장과 View를 호출하는 2가지
		 로직을 동시에 처리할수 있는 클래스
		 사용법
		 	참조변수.setViewName("뷰의 경로 및 파일명")
		 		->View설정
		 	참조변수.addObject("속성명", "속성값");
		 		->View로 전달할 데이터 저장
		 	뷰를 호출할때는 ModelAndView참조변수를 return한다.
	 */
	@RequestMapping(method=RequestMethod.POST, value="/requestMapping/postLogin.do")
	public ModelAndView postLogin(@RequestParam("user_id") String id,
			@RequestParam("user_pw") String pw) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("02RequestMapping/postLogin");
		mv.addObject("id", id);
		mv.addObject("pw", pw);
		
		return mv;
	}
	/*
	@ModelAttribute 어노테이션
		: 뷰로 전달되는 커맨드객체의 이름을 임의로 변경하고 싶을때
	 	사용한다. 아래코드는 studentDTO -> si 로 이름을 변경한 후
	 	View로 데이터를 전달한다.
	 */
	@RequestMapping("/requestMapping/modelAttribute")
	public String studentTnfo(@ModelAttribute("si") StudentDTO studentDTO) {
		return "02RequestMapping/modelAttribute";
	}
}
