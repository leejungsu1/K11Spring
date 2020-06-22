package common;

import javax.xml.bind.JAXBException;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/*
유효성 검증을 위한 클래스정의를 위해 Validator 인터페이스를 구현한다.
차후 supports(), validate() 두개의 메소드를 오버라이딩 해야한다.
 */
public class MemberValidator implements Validator {

	/*
	supports() 메소드
		: 매개변수로 정달되는 객체가 유효성검증을 지원할수있는
		커맨드객체인지 여부를 판단한다. 만약 해당 메소드를 통과하지
		못하면 유효성검증을 진행하는 validate()메소드는 호출되지
		않는다.
		해당 메소드는 자동으로 호출된다.
	 */
	public boolean supports(Class<?> clazz) {
		/*
		isAssignableFrom() : 커맨드객체가 아닐경우 false를 반환한다.
		 */
		return MemberDTO.class.isAssignableFrom(clazz);
	}
	/*
	validate() 메소드
		: supports()메소드가 true를 반환할 경우에만 호출되는 메소드로
		실제 폼값에 대한 검증을 진행한다.
		매개변수1 : 폼값을 저장한 커맨드 객체
		매개변수2 : 에러정보를 저장할 Errors타입의 변수
	 */
	public void validate(Object obj, Errors errors){
		
		System.out.println("validate() 메소드 호출됨");
		
		MemberDTO memberDTO = (MemberDTO)obj;
		//단순 if문을 통한 검증 : 아이디(id)
		String member_id = memberDTO.getId();
		if(member_id==null || member_id.trim().isEmpty()) {
			System.out.println("아이디가 null입니다.");
			//검증에 실해한 경우 해당메소드를 통해 결과 반환
			errors.rejectValue("id", "idError");
		}
		
		//내장메소드를 통한 검증 : 패스워드(pw)
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "pwError");
		
		//사용자정의 메소드를 통해 검증 : 이름(name)
		boolean nameValidate = myEmptyOrWhitespace(memberDTO.getName());
		if(nameValidate==false) {
			System.out.println("이름이 null 입니다.");
			errors.rejectValue("name","nameError");
		}
		
	}
	public boolean myEmptyOrWhitespace(String value) {
		if(value==null || value.trim().length()==0) {
			return false;
		}
		else {
			return true;
		}
	}
}
