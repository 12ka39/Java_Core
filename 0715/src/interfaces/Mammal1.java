// 인터 페이스
package interfaces;

public interface Mammal1{
	
	// 1. public static final이 생략된 상수만 가질 수 있다. (변수 가질 수 없다)
		// private 변수 못 씀. private int mon = 0 오류
	
	double PI = 3.141592;
	int mon =0;
	int sat = 0;
	
	public static final int TUE = 0; // 이거랑 같음
	
	// 2. public abstract 이 생략된 추상 메소드만을 가질 수 있다
	void display(); // 추상 메소드
	
}