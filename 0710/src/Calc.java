// 이거 수업중에 이해 못 했다

public class Calc {
	void calc(Student std) { // 계산만 하는 메소드
		int tot = std.getKor() + std.getEng() + std.getMath(); 
		std.setTot(tot);
		
		double avg = tot / 3.;
		std.setAvg(avg);
		
		char grade = (avg >=90)? 'A': (avg >=80)? 'B' : 
		  					(avg >=70)? 'C': (avg >=60)? 'D':'F';
		std.setGrade(grade);
	};
}
