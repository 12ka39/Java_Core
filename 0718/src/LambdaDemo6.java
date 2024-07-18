// 인터페이스 메소드에 파라미터가 2개인 람다
public class LambdaDemo6 {
	public static void main(String[] args) {
		//1. polymorphic parameter를 이용하자
		Person3 jimin = new Person3();
		jimin.greeting(new Say3() { // 익명 객체 (파라미터로 사용)

			@Override
			public int something(int a, int b) {
				System.out.println("I'm Jimin");
				System.out.println("Nice to meet you");
				return a * b;
			} 
		});
		
		//2. Lambda Expression 을 이용하자
		//new부터 메소드명 지우기
		jimin.greeting((a, b) ->{
				System.out.println("I'm Jimin");
				System.out.println("Nice to meet you");
				return a * b;
		});
	}
}



@FunctionalInterface
interface Say3{
	int something(int a, int b);  // 파라미터 2개
}	

class Person3{
	public void greeting(Say3 say) { // 인터페이스가 파라미터로 넘어감
		int value = say.something(5, 10);
		System.out.println("Value =" + value);
	}
}

