import java.util.Scanner;

public class Bmi {

	public static void main(String[] args) {
		/*
		 * 
		 (BMI) =  체중(kg)/[신장(m)]2(제곱)
		 * 
		이름:			- String
		신장(cm): 	- Float
		몸무게(kg): - Float
		--------------

		~~님의 BMI 지수 23.1이고 비만전단계입니다
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("체중(kg) :"  );
		float kg  = sc.nextFloat();
		
		System.out.print("신장(cm) : ");
		float cm = sc.nextFloat();
		float m = cm / 100;
		
		
		// (BMI) =  체중(kg)/[신장(m)]2(제곱)
		double bmi = kg / Math.pow(m, 2);  // 제곱 Math.pow(제곱할 숫자, 몇 제곱 할 거?)
		
		String result = "";
		
		if (bmi  < 18.5) {
			result = "저체중";
		} else if(18.5 <= bmi &&  bmi <= 22.9 ) {
			result = "정상";
		} else if(23 <= bmi &&  bmi <= 24.9 ) {
			result = "비만전단계";
		} else if(25 <= bmi &&  bmi <= 29.9 ) {
			result = "1단계 비만";
		} else if(30 <= bmi &&  bmi <= 34.9 ) {
			result = "2단계 비만";
		} else {
			result = "3단계 비만";
		}
		
		// %.1f 소수점 이하 한 자리
		System.out.printf("%s님의 BMI 지수는 %.1f 이고, %s 입니다", name, bmi, result);
		
	}

}
