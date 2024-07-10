import java.util.Scanner;

public class OpDemo {

	public static void main(String[] args) {
		short su = 5; 
		//short result = ~su; //// ~ 틸드 왜 에러?? type mismatch: cannot convert from int to short
				// +, -, ~ 가 들어간 식은 무조건 반환값이 int다
		int result = ~su;
		
		short result2 = true? 1970 : 2024;
		//short result3 = true? 1970 : 3.14; // 왜 에러? Type mismatch: cannot convert from double to short
			// 삼항 연산자는 true : false를 먼저 보고, 두 값의 타입을 맞춘 다음,
			// 조건을 본다. 그러니 여기서는 1970과 3.14의 타입을 맞춘다.
			// int : float니까 두 타입 모두 float가 된다,  1970이 실수가 된다.  1970.0
			// 그러니 실수를 short로 받으려고 하니까 에러가 나는 거 
			
		
		// 연습문제
		// 값 입력(초단위):3601  next int
		// 3601초는 1시간 1초입니다. (입력한 값을 시분초로)
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int time = sc.nextInt();
		int hour = time / 3600;
		int minute = (time %  3600) / 60;
		//int minute = (time - (hour * 3600)) / 60;
		// int cho = time - (hour * 3600 + minute * 60);
		int cho = time % 3600 % 60;
		
		//위에 주석 2줄도 맞는데
		// % 모듈러 연산자 사용하면 식이 더 간단하다
		
		System.out.printf("%d초는 %d시간 %d분 %d초 입니다 \n", time, hour, minute, cho);
		System.out.println(time + "초는 : " + hour + "시간" + minute + "분" + cho + "초 입니다");
		
		
		
	}

}
