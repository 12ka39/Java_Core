// 인터페이스에 메소드에 파라미터가 1개인 람다

public class LambdaDemo5 {
	public static void main(String[] args) {
		//1. polymorphic parameter를 이용하자
		// 여기 오류남
		/*
		Person2 jimin = new Person2();
		jimin.greeting(new Say2() { // 익명 객체 (파라미터로 사용)

			@Override
			public int something(int a) {
				System.out.println("I'm Jimin");
				System.out.println("Nice to meet you");
				return a * 10;
			} 
		}); */
		
		Person2 jimin = new Person2();
		
		//2. Lambda Expression 을 이용하자
		//new부터 메소드명 지우기
		jimin.greeting((a) -> {
				System.out.println("I'm Jimin");
				System.out.println("Nice to meet you");
				return a * 100;
		});
	}

}



@FunctionalInterface
interface Say2{
	int something(int a);  // 인터페이스에 파라미터가 하나 있다.
}
	

class Person2{
	public void greeting(Say2 say) { // 인터페이스가 파라미터로 넘어감
		int value = say.something(5);
		System.out.println("Value =" + value);
	}
}




















