
public class VariableDemo1 {

	public static void main(String[] args) {

		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("국어 점수: ");
		String kor = sc.nextLine(); // "80" 을 숫자 80으로 바꿔야 함
		// nextLine() 줄 단위로 불러온다
		int ko = Integer.parseInt(kor);
		
		System.out.print("수학점수: ");
		String math = sc.nextLine();
		int mat = Integer.parseInt(math);
		
		
		System.out.println(kor + math); // 문자열 더하기 
		System.out.println(ko + mat);  // 숫자 더하기
	}

}
