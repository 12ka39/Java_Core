
public class Output {
	void output(Student std) { // 출력만 하는 메소드
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("-----------------------------------------");
//		System.out.printf("%-10s%5d%5d%5d%5d%7.1f%3c%n",
//				std.hakbun, std.kor, std.eng, std.math, std.tot, std.avg, std.grade); 에러
//				                   -10 10칸인데, 왼쪽 정렬
		std.print();
	};
}
