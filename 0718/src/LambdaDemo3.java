 // return이 없는 람다

public class LambdaDemo3 {

	public static void main(String[] args) {
		Person jimin = new Person();
		//1, polymorphic parameter를 이용하자.
		
/*		jimin.greeting(new Say() { 익명 객체 (파라미터로 사용)
			@Override
			public void something() {
				System.out.println("I'm Jimin..");
				System.out.println("Nice to meet you.");
			}
		});
*/
		
		//2. Lambda Expression 을 이용하자   
		// (1번에서 삭제 들어갑니다~ new부터 메소드 명까지 다 지움) ..etc
		
		jimin.greeting(() -> {  System.out.println("I'm Jimin"); 
								System.out.println("Nice to meet you"); //구현 문장이 2개 이상이면 {} 생략 불가
		});
	}
}

@FunctionalInterface
interface Say{
	void something(); // 리턴이 없는 람다 사용하려고 만든 추상메소드
}

class Person{
	public void greeting(Say say) { // 인터페이스가 파라미터로 넘어감
		say.something();
	}
}
