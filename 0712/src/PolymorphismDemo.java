/*
 *다형성
 *1. 객체 형변환
 *		1) 자동 형변환,  implicit conversion, promotion
 *			자식 객체가 부모 객체로 형변환할 때 (고양이가 동물로 바뀔 때)
 *		2) 강제 형변환, explicit conversion, demotion
 *			부모 객체가 자식 객체로 형변활할 때. 단, instanceof 연산자가 true를 리턴할 때에만
 *2. Override method 
  */

public class PolymorphismDemo {
	public static void main(String[] args) {
		
		// (1) primitive type 형변환
		// 기본타입에서는 boolean 빼고는 형변환 된다
		int su =5;
		long lo = su;                // 자동 형변환, implicit conversion, promotion
		double avg = su; // 자동 형변환
		
		short sh = (short) avg; // 강제 형변환, explicit conversion, demotion
		
		
		// (2) 객체의 형변환
		Test t = new Test();
		Demo d = new Demo();
		
		//t= d; // 자동 형변환 
		// 노상관 객체 끼리는 형변환이 되지 않는다. Demo가 Test로 형변환 되지 않는다.
		// 뜬금 없는 아무 관계없는 객체끼리 바뀌지(형변환 되지) 않는다. 꽃이 유니콘이 되지 않음
		// 부모자식 관계일 경우에만 형변환 된다. (형변환 ! 상속관계 !!)
		
		/* instanceof 연산자.  형변환 가능여부.  T/F
		 * 가능하면 T를 반환 */
		if(t instanceof Demo) {  // 
			d = (Demo) t; // 강제 형변환
		} else {
			System.out.println("형변환 안 됨");
		}
		
		d = (Demo) t; // 강제 형변환 -> 오류 나는 거 정상. 왜? 서로 노상관 객체들이다. 부모자식이 아님@@ 
		/*
		Exception in thread "main" java.lang.ClassCastException: class Test cannot be cast to class Demo 
		(Test and Demo are in unnamed module of loader 'app')
		at PolymorphismDemo.main(PolymorphismDemo.java:39)

		 * */
	}
}

class Test{}
class Demo extends Test{}

