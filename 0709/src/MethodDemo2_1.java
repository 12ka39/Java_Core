class Product{
	int price;
}

// 메소드 호출 3) Call(Pass) by Referance

public class MethodDemo2_1 {

	public static void main(String[] args) {
		MethodDemo2_1 md = new MethodDemo2_1();
		Product ballpen = new Product(); ballpen.price= 100; // 정수변수 -> primitive (기본 타입)
		
		System.out.println("before = " +  ballpen.price); // call by Value
		md.change(ballpen); // 값으로 참조형이 넘어가면 -> call by referance
			//ballpen은 객체다. -> 즉 참조값
		
			// 원본(ballpen.price)의 숫자는 변하지 않는다. 
			// original 과 target은 서로 다른 공간에 있다. (값 복사)
		
			// 서로에게 영향을 주지 않는다.
		System.out.println("after = " +  ballpen.price);
	}
	
	void change(Product pencil) { // pencil = ballpen
		pencil.price = 50000;
	}
}
