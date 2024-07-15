// AbstractDemo1, Normal1 같은 클래스에 있음
public class AbstractDemo1 extends Normal1{
	public AbstractDemo1(String name) {
		super(name);
	}
	
	public static void main(String[] args) {
		// Normal1 normal = new Normal1();  오류. 추상 클래스는 객체 생성 못 한다
		Normal1 normal = new AbstractDemo1("김지민"); // 그래서 자식 클래스로 AbstractDemo1로 객체 생성한다.
		// 24줄 생성자에 김지민이 들어감
		normal.display(); // 다형성 -> 자식이 부모의 메소드를 사용한다
	}

	@Override
	public void display() {
		System.out.println(super.getName());
	} 
}

//추상 클래스. 반드시 자식 구현
abstract class Normal1{ 
	private String name;
	
	public Normal1(String name) { this.name = name; } // constructor -> 여기 김지민 들어감
		
	public  abstract void display(); // 추상 메소드~ 반드시 재정의 필요 
	
	public String getName() { return name; }  //getter

	public void setName(String name) { this.name = name; }  // setter
		
	@Override
	public String toString() { // toString -> 우클릭 -> 소스 -> toString
		return String.format("noraml [name=%s]", name);
	}
}
