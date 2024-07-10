//중첩반복문- 구구단
public class NestedLoopDemo {

	
	// 약간 구구단 찍는 방식이 다르다.
	// 2x1=2	3x1=3	4x1=4
	// 2x1=2, 2ㅌ2=4.. 이런 방식이 아님                                                                                                                                          
	public static void main(String[] args) {
		int i = 1; // i 초기화
		while(i<=9) { // i 조건 
			int dan = 2; // dan 초기화
			while(dan <=9) { // dan 조건
				System.out.print(dan + "x" + i + "=" + dan * i + "\t");
				dan++; // dan 증감식
			}
			System.out.println();
			i++; // i증감식
		}

/*		내가 짠 코드
		int count=0;
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=9; j++) {
				if(count % 8 == 0) {
					System.out.println();
				} else {System.out.print(j + "x" + i + "=" + i*j + "\t");
			}
				count++;
		}
		
	}
*/	
	
	
	
	
	/*
		A
		AB
		ABC...
		A........Z
	 */

		for(int j =1; j<=26; j++) {
			for (int k =1; k<=j; k++) {
				System.out.print((char)(k+64));
			}
			System.out.println();
		}
		
		
		System.out.println();
		
		//내가 짠 코드
		for (int k=65; k<=90; k++) {
			for (int l=65; l<=k; l++) {
				System.out.print((char)l);
			}
			System.out.println();
		}
		
		
	}

}
