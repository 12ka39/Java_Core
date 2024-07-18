// 리턴이 있는 람다
public class LambdaDemo4 {
	public static void main(String[] args) {
		Person1 jimin = new Person1();
		
		//1st polymorphic parameter를 이용하자.
/*		jimin.greeting(new Say1() {
			@Override
			public int something() {
				System.out.println("I'm Jimin..");
				System.out.println("Nice to meet you.");
				return 200;
			}
		});
*/
		//2nd Lambda Expression을 이용하자. (역시 1에서 하나하나 지워나가자)
		jimin.greeting(() -> {
				System.out.println("I'm Jimin..");
				System.out.println("Nice to meet you.");
				return 200;
			});
	}
}
@FunctionalInterface
interface Say1{
	int something();
}

class Person1{
	public void greeting(Say1 say) { // 인터페이스가 파라미터로 넘어감
		int value = say.something();
		System.out.println("value = " + value);
	}
}
