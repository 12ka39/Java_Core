/*
 * Method를 호출하는 방법 3가지
 * 1) Call(Pass) by Name ----------> calcHap() 이름으로 호출
 * 2) Call(Pass) by Value ----------> md.calcHap(3, 27)  매개 변수
 * 3) Call(Pass) by Referance
 * 
 * 1번 단점을 극복하려고 2번-> 2번 단점 극복하려고 3번 생김
 * */

// 메소드 호출 1) Call(Pass) by Name
public class MethodDemo {

	public static void main(String[] args) {
		MethodDemo  md = new MethodDemo();
		md.calcHap();
	}
	
	// 1~100까지의 합.
	// 메소드 필수 3요소  -> 반환형   메소드   (괄호)
	//			void calcHap()   | {}가 메소드 필수요소는 아니다. ex) 인터페이스 추상메소드를 보라.
	
	void calcHap() { // void 무치형 (값이 없는 형태 - 데이터 타입으로 안 본다)
		// 메소드 선언부 == 시그니처 (컴파일러가 메소드를 구분하는 기준)
		int hap = 0;
		for(int i=1; i<=100; i++) {
			hap +=i;
		}
		System.out.println("1부터 100까지의 합은 " + hap + "입니다");
	}
	
}

// Naming Convention 이름 짓는 법
/*
	1. Pascal Casing: Class, Interface, Enum (첫글자 대문자)

	2. Camel Casing: variable, method 

	3. Snake_Casing: snake_tail (대소문자 구별 안 하는 곳에서 사용)

	4. Kebab-Casing   ------------(대소문자 구별 안 하는 곳에서 사용)

*/