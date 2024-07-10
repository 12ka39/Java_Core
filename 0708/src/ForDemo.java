
public class ForDemo {
	public static void main(String[] args) {
		/*   a = 97  A = 65   32차이
		 A   B   C   D   E
		 f   g   h   i    j
		 K   L   M   N   O
		 p   q   r   s   t
		 */
		
		// 'A' ---> 65   encoding
		// 65 ---> 'A'   decoding
		
		
		//for문
		int count =0, line=1;

		
		for(int i = 65; i<=90 ; i++) { //A부터 Z
			if(line % 2 ==0) System.out.print((char)(i +32) + "\t"); // 소문자 출력
			else System.out.printf("%c\t", (char) i); // 대문자 출력
			count++; // 숫자 5개 찍으면 줄 넘기려고 필요한 변수
			if(count % 5 == 0) {
				System.out.println();
				line++;
			}
		}
		
		
		
		System.out.println();
		
		//while문
		
		int i = 65;
		int count2 =0, line2=1;

		while(i<=90) { //A부터 Z
			if(line2 % 2 ==0) System.out.print((char)(i +32) + "\t"); // 소문자 출력
			else System.out.printf((char) i + "\t"); // 대문자 출력
			count2++;
			if(count2 % 5 == 0) {
				System.out.println();
				line2++;
			}
			i++;
		}
	}

}
