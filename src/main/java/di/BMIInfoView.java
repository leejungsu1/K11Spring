package di;

import java.util.ArrayList;

public class BMIInfoView {
	
	//멤버변수
	private String name;		//이름 - 문자열(객체)
	private double height;		//신장(키) - 더블형(기본자료형)
	private double weight;		//몸무게
	private ArrayList<String> hobbys;	//취미(컬렉션)
	private BMICalResult bmiCalResult;	//체질량지수 계산결과(객체)
	
	//BMI지수를 계산하는 멤버변수 객체의 함수를 호출함
	public String bmiCalculation() {
		//몸무게와 신장을 매개변수로 전달하여 BMI지수 계산결과를 반환받음
		String bmiResult = bmiCalResult.bmiCalculation(weight, height);
		return bmiResult;
	}
	public String getInfo() {
		return String.format("이름 : %s<br/>"+"키 : %s<br/>"+"몸무게 : %s<br/>"
				+"취미 : %s<br/>%s", name, height, weight, hobbys, bmiCalculation());
	}
	
	//setter정의
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}
	public void setBmiCalResult(BMICalResult bmiCalResult) {
		this.bmiCalResult = bmiCalResult;
	}
	public String getName() {
		return name;
	}
	//getter정의
	public double getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public ArrayList<String> getHobbys() {
		return hobbys;
	}
	public BMICalResult getBmiCalResult() {
		return bmiCalResult;
	}

}
