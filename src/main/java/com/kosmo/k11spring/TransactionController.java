package com.kosmo.k11spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import transaction.TicketDAO;
import transaction.TicketDTO;
import transaction.TicketTplDAO;
@Controller
public class TransactionController {
	
	/*
	1. 트랜잭션매니저를 활용한 트랜잭션 처리를 위해
	servlet-context.xml에서 미리 생성한 DAO빈을 자동주입받는다.
	(트랜잭션 템플릿과 동시에 사용할수없으므로 주석처리한다.)
	 */
	 private TicketDAO dao;
	 /*
	 @Autowired 
	 public void setDao(TicketDAO dao) { 
	 this.dao = dao;
	 System.out.println("@Autowired=>TicketDAO주입성공"); }
	 */
	//티켓 구매 페이지
	@RequestMapping("/transaction/buyTicketMain.do")
	public String buyTicketMain() {
		
		return "08Transaction/buyTicketMain";
	}

	//티켓 구매 처리 페이지
	@RequestMapping("/transaction/buyTicketAction.do")
	public String buyTicketAction(TicketDTO ticketDTO, Model model) {
		/*
		TicketDTO 객체는 구매페이지의 폼값을 한번에 받아주는
		커맨드객체 역할을 한다. 즉 request객체가 필요없다.
		 */
		dao.buyTicket(ticketDTO);
		model.addAttribute("ticketInfo", ticketDTO);
		
		return "08Transaction/buyTicketAction";
	}
	
	
	/////////////////////////////////////////////////////////////////
	/*
	2. 트랜잭션 템플릿을 활용한 처리
	 */
	/*
	servlet-context.xml에서 생성한 TicketTplDAO타입의 빈을
	autowired 받음
	 */
	private TicketTplDAO daoTpl;
	@Autowired
	public void setDaTpl(TicketTplDAO daoTpl) {
		this.daoTpl = daoTpl;
	}
	//티켓구매페이지
	@RequestMapping("/transaction/buyTicketTpl.do")
	public String buyTicketTpl() {
		return "08Transaction/buyTicketTpl";
	}
	//티켓구매처리페이지
	@RequestMapping("/transaction/buyTicketTplAction.do")
	public String buyTicketTplAction(TicketDTO ticketDTO, Model model) {
		//티켓구매처리를 위한 DAO호출
		boolean isBool = daoTpl.buyTicket(ticketDTO);
		if(isBool==true) {
			model.addAttribute("successOrFail","티켓구매가 정상처리 되었습니다.");
		}
		else {
			model.addAttribute("successOrFail","티켓구매가 취소되었습니다. 다시 시도해 주세요.");
		}
		//뷰로 전달할 데이터 저장
		model.addAttribute("ticketInfo",ticketDTO);
		return "08Transaction/buyTicketTplAction";
	}
}
