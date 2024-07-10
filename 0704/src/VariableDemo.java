
public class VariableDemo {
	public static void main(String[] args) {
		
		// String 힙에 저장
		String name; // 변수 선언 Variable Declaration
		name ="한지민"; // 할당 Assignment
		String email = "aaa@aaa.com"; // 초기화 Initialization
		//변수 선언으로 변수의 성격, 타입, 사이즈를 알 수 있다
		

		// int su = 5; // primitive 변수 -> 스택에 저장
		System.out.printf("숫자5 = %d\n", 500);
		System.out.printf("숫자5 = %o\n", 500); // 8진수
		System.out.printf("숫자5 = %x\n", 500); // 16진수
		
		//int a = 32768L; //사이즈가 안 맞아서 4바이트 = 8바이트 오류.
		
		float f = 0.1234567890123456789f; 
		double d = 0.1234567890123456789;
		
		
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		
		// f = 0.12345679
		// d = 0.12345678901234568   
		/// flaot와 double은 정확도가 다르다
		
		
		
		byte a = 5; //int 는 4바이트인데, int 5는 00000000000000000 110 이라고 치자
		// 4바이트 (32비트 앞은 다 0이고 마지막 몇 자리만 5 나타내는 2진수임)
		// byte는 1바이트 뿐이라 int  앞에 3바이트 알아서 다 자른다
						 //
		 short a1 = 5;
		 
		//short a2 = 32768; // 범위 벗어나서 오류 남
		 short a2 = (short) 32768; // 강제형변환 해주면 오류 사라짐
		 System.out.println("a2 :" + a2); //근데 결과는 -32768   -가 되어버린다
		 
		byte b = 7;
		short  b1 = 7;
		
		short sum = 5 + 12;
		System.out.printf("sum=%d", sum);
		
		
		
		
		System.out.print('\n');
		System.out.print('A');
		System.out.print('B');
		System.out.print('\n');
		System.out.print('C');
		System.out.print('D');
		System.out.print('\b'); // 한 칸 뒤로 가기
		System.out.print('E'); // ->AB CE로 나와야하는데 CDE게 뜬다. 이거 이클립스 오류
		// 커맨드 라인에서 실행하면 오류 없이 뜬다
		

		System.out.println(true);
		System.out.println(false);
		System.out.println(4 > 5);
		System.out.println(4 != 5);

		
		System.out.println("Hello, World!"); // 문자열 String
		
		
		java.util.Scanner sc = new java.util.Scanner(System.in); 
		String name2 = "한지민";
		
		// sc, name2 모두 참조형 변수라 변수 크기는 같은데, 
		// 32bit CPU -> 4바이트 | 64bit CPU ->  8바이트
		// 지금 컴은 64bit니까 8바이트
		// 참조 변수 8바이트로 크기가 다 같다. 근데 왜 굳이 데이터 타입을 쓸까?

		// 주소 변수는 단순히 시작 주소만 가르키기 때문에~!
		// 변수의 사이즈 만큼의 공간이 저장되기 위해서는
		// 데이터 타입이 Scanner 타입이라고 알려줘서  
		// Scanner 타입 만큼의 크기를 공간으로 할당하라고 알려줘야 한다
		// 그래서 Scanner, String 이라고 데이터 타입 적어주는 거.
	
		
		short x = 10; // 형변환. short <- int
		short y = 20;
		
		// 그런데
		//short sum2 = x + y; //에러 왜?
		//Type mismatch: cannot convert from int to byte
		// 이항 연산은 무조건 int 이상이어야 한다. 걍 이런 법칙(문법)
		// 그래서 강제 형변환하자
		short sum2 = (short)(x + y);
	}
	
}
