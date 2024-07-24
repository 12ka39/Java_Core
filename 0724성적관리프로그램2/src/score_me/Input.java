package score_me;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {
	Student [] array;
	Scanner sc ;
	

	public Input(Student[] array) throws FileNotFoundException { // 생성자
		this.sc = new Scanner(new File("sungjuk_utf8.txt"));
		this.array = array;
	}

	void input() {
		for(int i=0; i<this.array.length; i++) {
			String line = this.sc.nextLine();
			
			Scanner s = new Scanner(line).useDelimiter("\\s+");
			String hakbun = s.next();
			String name = s.next();
			int kor = s.nextInt(); //  78
			int eng = s.nextInt(); //  87
			int mat = s.nextInt(); //  83
			int edp = s.nextInt(); //  78
			
			
			array[i] = new Student(hakbun, name, kor, eng, mat, edp);
			
		}
	}
	
}
