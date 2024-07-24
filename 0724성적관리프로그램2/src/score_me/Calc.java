package score_me;

public class Calc {
	
	Student [] array;

	public Calc(Student[] array) {
		this.array = array;
	}
	
	void calc() {
		for (Student std : this.array) {
			int tot = std.getEng() + std.getEdp() + std.getKor() + std.getMat();
			double avg = tot / 4. ;
			char grade = (avg >= 90)? 'A':
									(avg >=80)? 'B':
										(avg >70)?'C':
											(avg>60)? 'D':'F';
			
			std.setTot(tot);
			std.setAvg(avg);
			std.setGrade(grade);
		}
	}

}
