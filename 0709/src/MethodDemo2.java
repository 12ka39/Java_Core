/*
 *  call by value 값 복사는 original이 바뀌지 않는 단점이 있어서
 *  call by referance가 나온다
 * */

//메소드 호출   (2) Call(Pass) by Value 의 단점

public class MethodDemo2 {

	public static void main(String[] args) {
		MethodDemo2 md = new MethodDemo2();
		int original = 100;
		md.print(original); 
		System.out.println("original= " +  original); // call by Value
		
			// 오리지널의 숫자는 변하지 않는다. 
			// original 과 target은 서로 다른 공간에 있다. (값 복사)
			// 서로에게 영향을 주지 않는다.
	}
	void print(int target) { // target = original
		System.out.println("target= " +  target); // 처음에 100이었다가
		target = 50000; // 50000으로 바꿈
		System.out.println("target= " +  target); // target는 50000이 되지만..!  original은 변하지 않는다
	}

}
