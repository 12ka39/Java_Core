// final method
//  final 클래스는 상속이 안 되니까, 메소드는 자동적으로 final 처럼 된다

public class FinalDemo {
	public static void main(String[] args) {
		Parent bumo = new Jasik();
		bumo.display(); // 나는 자식의 메소드
	}
}


class Parent{
	public  final void display() {
		System.out.println("나는 부모의 메소드");
	}
}


class Jasik extends Parent{
	/*  final 메소드 - 재정의 불가
	
	@Override
	public void display() {
		System.out.println("나는 자식의 메소드");
	}
	*/ 
	
}
