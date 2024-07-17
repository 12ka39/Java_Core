// 스태틱 변수의 초기화는 스태틱 초기화 블럭으로 한다.

public class StaticDemo2 {
	private int a; // member variable	 		멤버 변수
	private final int B; // member constant  멤버 상수
	
	private static int c; // static variable		스태틱 변수
	private static final int D; // static constant  스태틱 상수
	
	
	{ // initializaion block 초기화 블록(생성자 보다 먼저 호출) : 멤버 변수, 멤버 상수 초기화, 객체 생성 때마다 자동 호출
		a = 5; 
		B = 100; // 멤버 변수, 멤서 상수 초기화
	}
	
	
	static { // static initializaion block 스태틱 초기화 블록 - 스태틱 변수, 스태틱 상수 초기화 - class 로딩 시 단 한번 수행
		c = 500;  // 스태틱 변수 초기화
		D = 1000;
	}
	
	
	public static void main(String[] args) {
		System.out.println(c + "," + D); // 500, 1000
	}
	
	void print() {
		int e; 
		final int F; 
	}
	
}


