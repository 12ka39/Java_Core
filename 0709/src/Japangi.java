import java.util.Scanner;

public class Japangi {

	public static void main(String[] args) {
/* 연습문제 -> 배열 활용
		className: Japangi
		Money: 145678
		--------------------
		50000: 2
		10000: 4 
		5000: 1
		1000: 0
		500: 1
		100: 1
		50: 1
		10: 2
		5: 1
		1: 3
		Again(y/n)?
*/
		int  [] array = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		Scanner sc = new Scanner(System.in);
		String y_n=null;
		
		do {
		
			System.out.print("가격을 입력하세요 : ");
			int money = sc.nextInt();
			for(int i=0; i<array.length; i++) {
				int mok = money/ array[i];
				System.out.println(array[i] + "원권 :" + mok + "장");
				money = money % array[i];
			
			}
			
			System.out.print("Again(y/n)?"); y_n = sc.next();
			y_n = y_n.toLowerCase(); // Y로 입력해도 y로 인식하도록
		
		}while(y_n.equals("y"));
		System.out.println("Program is over");
		}
	}


