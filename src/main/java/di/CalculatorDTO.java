package di;

public class CalculatorDTO {
	
	Calculator cal;
	private int firstNum;
	private int secondNum;
	//멤버메소드
	/*
	Calculator 클래스에 정의된 사칙연산 메소드를 각각 호출하는 
	역할만 수행하는 4가지 메소드를 정의함
	 */
	public double add() {
		return cal.adder(firstNum, secondNum);
	}
	public double sub() {
		return cal.sub(firstNum, secondNum);
	}
	public double mul() {
		return cal.multi(firstNum, secondNum);
	}
	public double div() {
		return cal.divide(firstNum, secondNum);
	}
	
	//getter/setter정의(자동완성 메뉴 사용)
	public Calculator getCal() {
		return cal;
	}
	public void setCal(Calculator cal) {
		this.cal = cal;
	}
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	
	
}
