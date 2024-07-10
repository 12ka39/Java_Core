import java.util.Scanner;
// 반복문
public class LoopDemo {

	public static void main(String[] args) {
		// A~Z까지 출력하기
		
		// 시작과 끝이 명확하면 for문을 쓴다
		
		int i=65; //Initialization
		for(  ;i<=90;  ) { // 이렇게 초기값과 증감식을 조건에서 생략할 수 있다.
				// 초기값은 위에서 미리 정해줬고, 증감식은 { }에서 i++로 적어줌
			System.out.printf("%c\t", (char)i);
			i++;
		}
		
		System.out.println("");
		
		int j=90; //Initialization
		for(  ;j>=65;  ) { // 이렇게 초기값과 증감식을 조건에서 생략할 수 있다.
				// 초기값은 위에서 미리 정해줬고, 증감식은 { }에서 i++로 적어줌
			System.out.printf("%c\t", (char)j);
			j -= 3; // j = j-3
		}
		
		System.out.println("");
		
		
		
		
		
		//알파벳 5개씩만 찍기
		int k=65; //Initialization
		int number = 0;
		for(  ;k<=90;  ) { // 이렇게 초기값과 증감식을 조건에서 생략할 수 있다.
				// 초기값은 위에서 미리 정해줬고, 증감식은 { }에서 i++로 적어줌
			
			System.out.printf("%c\t", (char)k);
			k++;
			number++;
			
			if (number % 5 ==0 ) { // 5의 배수라면 5개마다
				System.out.println("\n");
			}
			
		}
		
		
		
		
		//문제 1부터 100까지 자연수 중 4의 배수는 몇 개인가?
		int count=0;
		for (int four=1 ; four <=100 ; four++) {
			if (four % 4 == 0) {
				count++;
				// count = count+1 이라고 하지 말고 1더하는 거면 count++ 로 하자
			}
		}
		System.out.printf("갯수는 %d\n", count);

		
		
		
		// Year: 2024
		// 2024년 윤년입니다.




		Scanner sc = new Scanner(System.in);
		System.out.println("연도를 입력하세요 : ");
		int leapYear = sc.nextInt();
		
		//  ||  ---- 왼쪽 식이 참이어도 오른쪽 식을 계산한다
		//  |   ------------ 시간을 줄이려고 사용. 왼쪽이 참이면 다음 계산 패스. 오른쪽 계산x
		
		// & , && 차이는 거짓
		
		if ((leapYear % 400 == 0) | (leapYear % 4 ==0  &&  leapYear % 100 != 0)) {
			System.out.println("윤년입니다");
		} else {
			System.out.println("평년입니다");
		}
		
		
		
		
	}

}
