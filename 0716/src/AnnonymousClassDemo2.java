// 3. 익명 객체의 파라미터 사용

public class AnnonymousClassDemo2 {

	public static void main(String[] args) {
		AnnonymousClassDemo2 acd = new AnnonymousClassDemo2();
		//Dog dog = new Dog();
		//acd.display(dog); //-- 기존 방식
		
		acd.display(new Mammal() { // 이걸 자주 쓴다. 파라미터로 익명객체를 사용한다
			
			@Override
			public void sound() {
				System.out.println("멍멍");
			}
		});
	}
	
	void display(Mammal m) {
		m.sound();
	}
}

interface Mammal{
	void sound();
}


// 익명 객체를 사용하지 않을 경우 필요한 거 (현재코드에선 필요 없는 코드
class Dog implements Mammal{

	@Override
	public void sound() {
		System.out.println("멍멍");
	}
 }