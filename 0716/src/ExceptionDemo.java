//  런타임 오류 & 컴파일 오류

// 예외 (Exception) (1) 런타임 오류 | 런타임(실행) 시 나타나는 오류
// 컴파일(저장)했을 땐 오류 안 뜨다가 유저가 실행했을 때 오류남
// 컴파일 단계에서는 문법만 검사한다.

// 컴파일 오류 = 문법 오류 : checked exception
// 런타임 오류 = 실행 오류 : unchecked exception (런타임 익셉션의 자식들)

// 런타임 exception의 자식들은 모두 unchecked exception

import java.io.File;
import java.util.Scanner;

public class ExceptionDemo {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 ////////////////////////////////////////////////////////////////
		 ////// 런타임 오류 -> 실행하면 오류남 (컴파일(문법검사) 단계에서는 오류 없음) Unchecked exception
		 
		System.out.print("반드시 숫자만 입력하세요 ? :");
		int don = sc.nextInt(); // NumberFormatException
		
		
		
		Car carnival = new Car();
		carnival.name = "기아 카니발";
		System.out.println(carnival.name);
		carnival = null; // NullPointerException 
		
		if(carnival != null) System.out.println(carnival.name);
		else System.out.println("이미 사망");
		
		
		String money ="30_000_000원";
		int intMoney = Integer.parseInt(money); // NumberFormatException 에러
		// 컴파일할 때는 몰랐는데, 런타임할 때 오류 생기는게 런타입 익셉션
		
		
		
		
		
		int[] array = {1,2,3,4};
		for(int i=0; i<=4; i++) {
			System.out.println(array[i]); // ArrayIndexOutOfBoundsException
		}
		
		int [] array1 = new int[-3]; // NegativeArraySizeException
		
		
		
		/////////////////////////////////////////////////////////////////
		// 컴파일 오류 = 문법 오류 : checked exception
		
		sc = new Scanner(new File("ExceptionDemo.java")); // 일부러 오류 냈음. 오류 나는 거 정상
	}
}


class Car{
	public String name;
}
























