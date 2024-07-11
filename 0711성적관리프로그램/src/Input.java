import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input { // 파일 입력
	private java.util.Scanner sc; 
	private Student [] array;
	
	
	public Input(Student[] array) throws FileNotFoundException { // 생성자
		this.sc = new Scanner(new File("sungjuk_utf8.txt"));
		this.array = array; // 파라미터로 넘어온 array를 this.array에 보내준다
	}
	
	void input() {
		for(int i=0; i<this.array.length; i++) {
			
			String line = this.sc.nextLine(); //(생성자에 있는) 나 의  스캐너에서 한 줄을 읽는다.  S1101     한송이     78     87     83    78
			//문자열 파싱 -> String[] = String클래스의 split(정규식)  --- 지난 시간에 배운 거
			
			//Scanner를 이용한 파싱. trim할 필요 없다
			Scanner s = new Scanner(line).useDelimiter("\\s+");
				// 스캐너는 line으로 파싱할래,    useDelimiter(구분자)를 
			String hakbun = s.next(); // S1101  -  trim 안 해도 된다
			String name = s.next(); // 한송이
			int kor = s.nextInt(); //  78
			int eng = s.nextInt(); //  87
			int mat = s.nextInt(); //  83
			int edp = s.nextInt(); //  78
			
			// 생성자로 객체 만들기
			this.array[i] = new Student(hakbun, name, kor, eng, mat, edp); // 이때 비로소 학생이 만들어 진다.
			
		}
		
	}
}
