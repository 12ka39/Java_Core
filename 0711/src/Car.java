
public class Car {
	
	
	private String name;
	private int price;
	
	// 이 코드는 없어도 된다
	public Car() {// 기본 생성자는 컴파일러가 알아서 코딩해주기 때문
		this.name = null; // 초기화도 알아서 해줌
		this.price = 0;
	}	
	
	//private Car() {};
	
	
	public void setName(String name) {
		this.name = name;
		// ThisDemo 에서 sonata는 지역변수라
	}
	
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String getName() {
		return  this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	
	//this를 설명하기 위해 억지로 만든 코드
	public Car clone() { // 자동차 복제 (주소 복사)
		return this; // 자기집 주소를 넘긴다. (집열쇠-권한 남겨줌)
		//참조 주소 타입이 Car니까 반환 타입이 Car
	}
	
}
