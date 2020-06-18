package common;

public class MemberDTO {
	
	//멤버변수
	private String id;
	private String pw;
	private String name;
	private String email;
	
	//기본생성자는 디폴트로 삽입
	//getter/setter
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
