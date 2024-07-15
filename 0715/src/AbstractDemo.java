
public class AbstractDemo extends Normal {
	
	public AbstractDemo(String name) { // 생성자
		super(name); // 
	}

	public static void main(String[] args) { 
		// Normal normal = new Normal("한지민");  // Normal 클래스는 추상 클래스라 객체 생성 X
		Normal normal = new AbstractDemo("한지민");
		// 선언은 부모형 = 실제는 자식(자기 자신)
		System.out.println(normal); // normal.toString()  재정의 했음
		}
}

abstract class Normal{ // 추상 클래스. 반드시 자식 구현
	private String name;
	
	public Normal (String name) { // 생성자
		super(); // 이 코드 없어도 알아서 부모 생성자 불러옴
		this.name = name;
	}

	
	// 게터 세터
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	

	@Override
	public String toString() { // toString -> 우클릭 -> 소스 -> toString -> String.format 선택
		return String.format("noraml [name=%s]", name);
	}
}