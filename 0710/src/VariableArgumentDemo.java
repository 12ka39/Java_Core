// 가변인자 -> 보내는 인자의 수가 정해지지 않았다. -> 인자가 가변적이다
// 자바 1.5버전에서 생긴 기능

// 호출할 때(넘어가는 거) 쓰는 게 인자,
// 받을 때 쓰는 게 매개변수인데 요즘 책에서는 이 둘을 잘 구분하지 않는다.


public class VariableArgumentDemo {
	public static void main(String[] args) {
		VariableArgumentDemo vad = new VariableArgumentDemo();
		
		//보내는 쪽에서 배열로 안 보내도, 받는 쪽에서 배열로 받는다
		int a =5, b=7, c=8;
		//int [] array = {3,4,5};
		vad.change(a,b,c); // argument, 인자(인수) -> 넘어가는 거
		
		System.out.println();
		
		int d =5; char e = 'B';  boolean f = true;
		vad.change2(d,e,f);
	}
	
	
	void change(int ... A) { // parameter, 매개변수 -> 받는 거
			// ... A  -> A는 배열이다. 보내는 쪽에서 배열이 아닌 걸로 보내는데, 받는 쪽에서 배열로 받는다.
			// 이 경우 [] A로 받으면 안 된다. 왜냐면 보내는 애가 배열로 보내지 않았으니까.
			// 근데 ... A는 배열이다.
			for (int i : A) {
				System.out.println(i);
			}
	}
	

	void change2(Object ... A) { // 모든 걸 모든 부모의 조상 Object로 받는다.
			// 근데 보내는 사람은 데이터 타입을 알지만, 받는 사람은 받는 게 뭔지 모른다.
			// generic 을 사용하면 받는 게 뭔지 알 수 있다 
		System.out.println("A의 길이" + A.length);
		for (Object i : A) {
			System.out.println(i);
		}
	}

}
