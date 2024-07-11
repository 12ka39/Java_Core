
public class ConstrutorDemo1 {
	public static void main(String[] args) {
		MyDate today = new MyDate();
		System.out.println(today.year);
	}
}

class MyDate{
	int year, month, day;
	
	
	// 기본 생성자를 목적에 맞게 재정의 하는 것을 생성자 재정의 (오버라이딩) 이라고 한다
	public MyDate() { // default constructor's overriding
		this.year =2024; 
		this.month =7; 
		this.day =11; 
	}
	
}
