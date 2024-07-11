
public class Calc {
	private Student [] array; //field
	
	public Calc(Student[] array) { // 생성자
		this.array = array; // 이 넘어온 array는 input 해서 내용 들어간 배열
	}
	
	void calc() { // 메소드. 보안 때문에 public을 안 쓰고 있다. 패키지에서만 이 메소드 쓰니까
		for (Student std : this.array) {
			int tot = std.getKor() + std.getEng() + std.getMat() + std.getEdp();
			double avg = tot / 4.;
			char grade = (avg >=90)? 'A':
									(avg >=80)? 'B':
										 (avg >=70)? 'C':
											 (avg >=60)? 'D':'F';
			
			std.setTot(tot);   std.setAvg(avg);   std.setGrade(grade);
		}
		
	}
	
}
