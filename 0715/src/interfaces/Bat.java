// 박쥐는 포유류 이면서 조류
// C++은 다중상속이 되지만, java는 다중 상속이 안 된다!
// 그래서 extends 와 implements를 사용한다

// (단, 인터페이스는 다중 상속 가능)
package interfaces;

public class Bat extends Mammal2 implements Birds{

	@Override
	public void fly() {
		System.out.println("하늘을 날다");
	}

	@Override
	public void giveBirthto() {
		System.out.println("새끼를 낳다");
	}
	
	
	public static void main(String[] args) {
		Bat bat = new Bat();
		
		bat.fly();
		bat.giveBirthto();
	}

}
