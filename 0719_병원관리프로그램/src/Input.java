import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
	private List<Hospital> list = new ArrayList<Hospital>(5);
	private Scanner sc, sc1;

	
	
	
	
	public Input(List<Hospital> list, Scanner sc) {
		this.list = list;
		this.sc = new Scanner(System.in);
		this.sc1 = new Scanner(System.in);
	}


	int input() {
		String io = null;
		int count = 0;
		
		System.out.println("    << 병원관리 프로그램>>");
		
		do {
		
			System.out.println("환자 정보를 입력하세요");
			System.out.print("번호: ");
			int num = sc.nextInt();
			System.out.print("진료코드: ");
			String code = sc.next();
			System.out.print("입원일수: ");
			int day = sc.nextInt();
			System.out.print("나 이: ");
			int age = sc.nextInt();
			// this.list.add(0) = new Hospital(num, code, day, age);
			count++;
			
			System.out.print("입력/출력 (I/O)? : ");
			io = sc1.next();
			io = io.toLowerCase();
			
		} while(io.equals("i")  && count<this.list.length);
		return count;
	}

}
