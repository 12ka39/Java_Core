// 멤버 메소드와 static 메소드의 비교 
// static 메소드 -> 주소 없이 접근할 때 사용

public class StaticDemo1 {
	// 프로그램이 시작하면 static부터 메모리에 올라가니까
	// print()가 제일 먼저 실행되어 b에 저장되고,
	// 그 다음에 main이 실행된다. 
	
	//console창에 찍힌 순서로 확인할 수 있다
	
	private int a; // member variable
	private static int b = print(); // static variable 
		// b를 초기화하기 위해 print() 메소드 호출. 예문을 위해 쓴 코드이지, 실제로 이렇게 사용X
		// 실제로는
		// static 변수, 상수는 StaticDemo2 에 있는 tatic initializaion block 으로 초기화 한다
	
	public static void main(String[] args) {
		System.out.println("나는 메인 메소드");
	}

	
	void display() { // member method
	}
	
	
	static int print() { // static method
		System.out.println("나는 스태틱 메소드~~!!!");
		return 30_000_000;
	}
	
}
