
public class AbstractDemo {
	public static void main(String[] args) {
		//Tiger t = new Tiger();  //오류. Tiger는 추상클래스나 집(객체)을 만들 수 없다
		
		Tiger t = new Lion();		
		t.display(); // 나는 자식 메소드
	}
}

//추상클래스를 만드는 이유. 강제로 메소드 재정의를 하기 위해서
// 추상클래스는 일반 메소드, 추상 메소드 둘 다 가질수 있다.

/*
	일반메소드 200개 있어도 추상메소드 1개 있으면
	추상클래스라고 선언해야하고,
	이 추상클래스는 객체를 생성할 수 없다
*/

abstract class Apple{
	public void print() { System.out.println("나는 정상적인 메소드"); }
}


abstract class Tiger{ // 추상(허상) 클래스. 실제 존재하지 않는 클래스라 집을 지을 수 없음
	public abstract void display(); // 추상 메소드는 바디 {} 가 없다
	
	public void print() { System.out.println("나는 정상적인 메소드"); }
}


class Lion extends Tiger{
	public void display() {
		System.out.println("나는 자식 메소드");
	}	
}
