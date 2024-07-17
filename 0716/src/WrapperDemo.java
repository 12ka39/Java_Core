// 래퍼 클래스
public class WrapperDemo {

	public static void main(String[] args) {
		/*
		int su = 5; // stack에 있는 5
		Integer in = new Integer(su); // Heap에 있는 5 // Wrapping, Boxing 
		// int another = Integer. // unwrapping, unboxing    1.4때까지 쓰던 거. 지금은 잘 안 씀	
		*/
		
		int su = 5;
		Integer in = su * 100; // auto-boxing 자동 박싱
		int another = in; // auto - unboxing 자동 언박싱
		System.out.println(another); // 500
		// primitive 타입이 8개라 래퍼 클래스도 8개
		// 자동으로 박싱 언박싱이 되는 듯..
		
	}

}
