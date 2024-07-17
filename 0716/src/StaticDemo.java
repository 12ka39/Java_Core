// 멤버 변수와 static 변수의 비교
// 멤버변수와 static 변수가 완전히 다르다는 걸 알기 위한 코드
public class StaticDemo {

	public static void main(String[] args) {
		Tiger [] array = new Tiger[4]; // 배열 공간 만들기
		
		for(int i=0; i<array.length; i++) {
			array[i] = new Tiger(); // 여기서 각각의 Tiger 클래스가 만들어진다.
		}
		
		// 여기서는 array[0] a=1, b=1 이 되고,
		// array[1] a=1, b=2
		// array[2] a=1, b=3
		// array[3] a=1, b=4 가 되는데
		
		// 최종적으로 for문 돌려서 찍을 땐, static변수는 이미 4가 된 상태라 전부 4가 찍힌다.
		for (Tiger t : array)  System.out.println("a =" + t.a + ", \t  b=" + Tiger.b);
		/*  
			 a =1, 	  b=4		--> static 변수는 공유하는 변수다
		 */
	}
}

class Tiger{

	int a;
	static int b;
	
	public Tiger() {
		a++;
		b++;
	}
}