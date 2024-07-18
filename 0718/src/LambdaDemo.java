/*
 	Lambda & Stream API
 	1. Lambda >> 클래스 소속이 아님
 	
 	 1) 원래 객체지향언어에서 사용하지 않고, Scala나 Groovy 같은 함수형 언어에서 사용하던 문법
 	 	AWS 람다는 function ||  JAVA 람다는 Expression (표현식) 이다
 	 	
 	 2) 메소드는 클래스 안에서 객체의 행위를 정의하지만, Expression이라고 쓴 이유는 Method의 역할과 동일하지만 
 	 	 특정 클래스 소속이 아니기 때문이다.
 	 
 	 3) Lambda Expression을 사용하면서 매개변수와 리턴 타입만으로 간단히 코드를 작성할 수 있기 때문에
 	 병렬 프로그래밍을 하지 않아도 되어 Collection Framework에서 효과적인 코드를 작성할 수 있다.
 	 -> 컬렉션 프레임워크 때문에 람다와 스트림 API를 사용한다
 	 
 	 4) 순서 (먼저 익명객체를 만들고 그 상태에서 이렇게 지우면 쉽게 만들 수 있다)
 	 	-객체의 생성부분을 삭제한다 (new 부분)
 	 	- @Override annotation을 삭제한다
 	 	- 접근지정자, 리턴타입, 메소드이름을 삭제한다 
 	 	- 파라미터 이름을 삭제한다
 	 		-- 굳이 파라미터 타입을 정의하지 않아도 추론이 가능하다면 파라미터 타입을 삭제 가능하고,
 	 		-- 추론이 불가능하면 파라미터 타입을 명시하는데, 모두 명시해야 한다.
 	 		
 	 	- 메소드의 바디의 return을 삭제한다
 	 	- 메소드 () 뒤의 {}를 삭제한다. 
 	 		-- 메소드의 구현부의 문장이 한 개일 경우에만 
 	 	- 메소드 파라미터 선언부 괄호 {} 사이였던 부분을 -> 연산자로 연결한다.	
 	 		

 	 		// 파라미터 타입 추정 가능하다면 파라미터 데이터 타입 생략 가능
			// 구현부 문장이 한 개일 경우 생략 가능
			// ->
			// return 없앤다
	
 * */


public class LambdaDemo {

	public static void main(String[] args) {
		
		/*	방법1) 정석 ---- 자식 생성하고, 
		int c = 5, d= 10;
		jasik ja = new jasik();  nt result = ja.add(c, d);
		System.out.println("result = " + result);
		
	}
	*/
	/* 2) 익명객체 사용 (코드 미완인데 대충 이해하자)
		int c = 5, d= 10;
		MyInterface mi = new MyInterface() {

			@Override
			public int add(int a, int b) {
				return a + b;
			}};
	*/ 
		
	// 3) 람다 Expression -> 코드 라인 수가 줄어든다

		int c = 5, d= 10;
		
		MyInterface mi = (a, b) -> a + b; // 이거 한 줄이면 끝
		int result = mi.add(c, d);
		System.out.println("result =" + result);
	}
	
	
	}
	












@FunctionalInterface  // 너는 Lambda Expression (람다 표현식) 을 사용할 수 있는 자격이 된다는 표시
// @override 처럼 안 써줘도 되지만 써주면 컴파일러가 확실하게 인식한다	 
interface MyInterface{
	int add(int a, int b);
}


// 이 코드는 방법1) 정석대로 했을 때 필요한 코드 
class jasik implements MyInterface{  
	@Override
	public int add(int a, int b) {
		return a + b;
	}
	
	

}












