

//자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
//예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
//
//제한사항
//N의 범위 : 100,000,000 이하의 자연수

import java.util.Scanner;

public class question1 {
	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.print("숫자를 입력하세요: ");
		
			int number = scan.nextInt();
			if(number > 0 && number < 100000000) {
				solution(number);
			} else {
				System.out.println("입력 범위 : 100,000,000 이하의 자연수");
			}
	    }		
		
	
	
	public static void solution(int number) {
        int result = 0;
		
        do {
        	int calc = number % 10;
        	System.out.println(result);
        	result += calc;
        } while (number%10 == 0);
        
       
        System.out.println(result);

	}
}
