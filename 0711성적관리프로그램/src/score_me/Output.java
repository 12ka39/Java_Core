package score_me;

public class Output {
	Student [] array;
	
	public Output(Student[] array) {
		this.array = array;
	}
	
	void output() { // 출력
		for (Student std : this.array) {
			System.out.printf("%-20s\t%5s\t%5d\t%5d\t%5d\t%5d\t%5d\t%5.1f\t%5c%n",
					std.getHakbun(), std.getName(), std.getKor(), std.getEng(), std.getMat(), std.getEdp(),
					std.getTot(), std.getAvg(), std.getGrade());
		}
	}

}
