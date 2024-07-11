package inheritance;

//자식 클래스 - 고양이
public class Cat extends Mammal{
	public String name = "나는 고양이~~!!"; // 오버 섀도우 변수
	
	public void print() { // 메소드 오버라이딩
		System.out.println("나는 고양이다 ...");
	}
}
