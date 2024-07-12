
public class Output {
	private Student [] array;
	
	public Output(Student[] array) { // 생성자
		this.array = array; // 계산이 끝난 array를 받았다
	}
	
	void output() {
		for (Student std : this.array) {
			/*
			System.out.printf("%-5s\t%7s\t%5d\t%5d\t%5d\t%5d\t%5d\t%8.1f\t%5c%n",
					std.getHakbun(), std.getName(), std.getKor(), std.getEng(), std.getMat(), std.getEdp(),
					std.getTot(), std.getAvg(), std.getGrade());
			*/
			System.out.println(std); // std.toString() // 이렇게 하면 출력한다.
												//toString 재정의 
			
				// --> std 는 std.toString()이 숨겨져있는 거라고 한다
				// std 는 객체라서 주소값을 가지고 있다
				// Object 클래스의 toString 메서드는 객체가 인스턴스인 클래스의 이름, '@' 기호, 
				// 그리고 객체의 해시 코드의 부호 없는 16진수 표현으로 구성된 문자열을 반환합니다.	
				// 재정의를 안 하면 해시코드를 찍는데
				// 딱히 해시코드를 찍어봐야 의미가 없다.
				// 그래서 재정의해서 학생 정보 출력하는 메서드로 새로 바꿨다.
		}
	}

}
