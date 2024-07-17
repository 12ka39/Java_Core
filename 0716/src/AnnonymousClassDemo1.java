// 인터페이스 익명 객체

// 2) 인터페이스를 구현하는 익명 객체 (이걸 더 많이 쓴다)

public class AnnonymousClassDemo1 {
	public static void main(String[] args) {

		Birds bi = new Birds() { // 인터페이스의 익명 객체
											// Birds를 만든 게 아니라 Birds의 자식을 만든건데 1회성 익명객체다
			// 필드와 메소드를 선언할 수 있지만, 익명 객체 내부에서만 사용할 수 있다. 

			@Override
			public void roam() {
				System.out.println("여기저기 배회하다");
			}
			
			@Override
			public void fly() {
				System.out.println("하늘을 날다");
			}
		};
		
		bi.fly();
		bi.roam();
		
	}
}

// 인터페이스
interface Birds{
	
	void fly();
	void roam();
	
}
