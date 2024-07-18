/*
@FunctionalInterface <- 너는 Lambda Expression을 사용할 수 있는 자격이 된다는 표시

	1. 일반적으로 인터페이스는 한 개 이상의 추상 메소드를 가질 수 있다.
	2. 하지만 여러 개의 추상 메소드가 있으면 Lambda Expression에 에러가 발생한다
	3. 그래서 Lambda Expression에서 사용하기 위한 인터페이스를 지정하기 위한 어노테이션이다

*/ 
public class LambdaDemo2 {

	public static void main(String[] args) {
		int a = 5, b= 10;
		/* 1번째 방법) Anonymous Class(익명객체) 를 이용하자 
		Comparable  com = new Comparable() { // 익명 객체
			
			@Override
			public int compare(int front, int back) {

				return front - back;
			}
		};
		int max = com.compare(a, b);
		System.out.println(max);
	
	*/ // 위의 긴 코드가 한 줄로 변한다. (일단 new부터 메소드 이름까지 다 지운다)
		Comparable  com = (front, back) -> front - back; // -5
		
		
		int max = com.compare(a, b);
		System.out.println(max);
		
		
		/*  2번째 방법 ) Polymorphic Parameter를 이용하는 방법 -> 익명객체랑 차이 없는데 파라미터로 가냐 아니냐의 차이인 듯?
/*		calculator(new Comparable() {
			@Override
			public int compare(int front, int back) {
			
				return front - back;
			}
		});
		
		*/
		calculator((front, back) -> front - back);
	}
	
	
	private static void calculator(Comparable comp) {
		int a = 5, b = 10;
		int result = comp.compare(a, b);
		System.out.println("result = " + result); // result = -5
	}
}
		

@FunctionalInterface
interface Comparable{
	int compare(int front, int back); // 추상 메소드
}

