import java.util.Scanner;

public class SungjukMgmt {
	//메인이 이렇게 복잡하면 안 된다. 안 좋은 코드
	// 다 나눠야 한다. 지금은 아직 배우는 중이니까.

	public static void main(String[] args) {
		Student chulsu = new Student();
			//chulsu 변수는 참조형이라 8바이트
		Scanner sc = new Scanner(System.in); // 키보드로 입력받을 거야
		String y_n = null;
		
		do {
			System.out.print("학번 : ");
			chulsu.hakbun = sc.next(); 
				//nextLine()의 단점. 엔터가 같이 따라 들어온다.
				//next()의 단점. 공백을 만나면 그 전까지만 읽어온다
			
			System.out.print("국어 : ");
			chulsu.kor = sc.nextInt();
			
			System.out.print("영어 : ");
			chulsu.eng = sc.nextInt();
			
			System.out.print("수학 : ");
			chulsu.math = sc.nextInt();
			
			
			chulsu.tot = chulsu.kor + chulsu.eng + chulsu.math;
			chulsu.avg = chulsu.tot/ (double) 3;
				//왜냐면 avg는 double 타입이라 총점이나 3 둘 중 하나는 실수로
				// 만들어야 한다 걍 3. 이라고 해도 됨
	
			chulsu.grade ='\0'; // 널값~!!!!! == '\u0000'
			
			//switch 조건에 실수는 못 온다. 그래서 int 강제형변환
			switch((int)(chulsu.avg/10)) {
				case 10: case 9: chulsu.grade = 'A'; break;
				case 8: chulsu.grade = 'B'; break;
				case 7: chulsu.grade = 'C'; break;
				case 6: chulsu.grade = 'D'; break;
				default: chulsu.grade = 'F';
			} // \t 탭    %10s\t  이게 한 세트   
			  // \n은 OS를 타기 때문에 %n으로 한다
			
			System.out.printf("%10s\t%5d\t%5d\t%5d\t%5d\t%10.1f\t %3c%n",
					chulsu.hakbun, chulsu.kor, chulsu.eng, chulsu.math, 
					chulsu.tot, chulsu.avg, chulsu.grade);
		
			System.out.println("Again(y/n)");
			y_n = sc.next();
		}while(y_n.equals("Y") || y_n.equals("y"));
		System.out.println("Program is over...");
	}

}


