import java.util.Scanner;

public class DoDemo {
	//while문은 무한루프에 대한 부담이 있으니 do-while을 한다
	public static void main(String[] args) {
		//4! = 4*3*2*1
		
		String y_n=null; // 참조형 변수 null 번지 
		Scanner sc = new Scanner(System.in); 
		
		do {
			System.out.print("몇 Factorial?? :");
			int su = sc.nextInt();
			
			int answer = 1;
			for(int i=su; i>0; i--) {
				answer *=i; // answer = answer * i
			}
			
			System.out.println(su + "!=" + answer);
			System.out.print("Again(y/n)?");
			y_n = sc.next(); // 중괄호 안에 있는 지역변수는 괄호 벗어나면 소멸됨. 그러니까 전역변수로 뺀다
		}while(y_n.equals("Y") || y_n.equals("y")); 
		
	}

}
