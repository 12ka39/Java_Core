import java.util.Scanner;

// Call by Referance
// Call by Referance 를 사용하는 이유 (장점) ->  역할을 나눌 수 있다. 모듈화. 컴포넌트화 = 유지보수가 좋다
// 		참조하는 곳의 값을 여러 곳에서 바꿀 수 있기 때문에 (
// 		메인에서 값 바꾸지 않아도 함수에서 값 바꾼 다음에, 메인에서는 바뀐 값 출력만 하면 된다


public class whatisit {

	public static void main(String[] args) { // 메인 코드는 호출만 한다. 
		Student1 yh = new Student1(); // yh에는 주소값이 들어있다.
		
		whatisit d = new whatisit();
		d.input(yh); // yh 넘길 때 주소값 넘어간다. Call by referance 
		System.out.println("영희의 국어점수 :" + yh.kor); // input함수에서 입력한 kor 값이 나온다
		d.calc(yh);
		d.output(yh);
		
		
	}
	
	// 메소드 별로 역할을 나눈다.
	
	// 메소드마다 std라는 같은 변수명을 써도 된다. std는 지역변수라서
	void input(Student1 std) { // Student std -> yh ->  call by ref  (같은 객체를 가리킨다)
										// 주소를 가리킨다 => 전권을 넘기는거. 집 열쇠 넘기는거
			// 지금 yh가 input 함수의 Student std로 넘어왔는데 
			// yh 의 주소를 넘겼다는 건 -> 집 열쇠 넘긴 거다.

		Scanner sc = new Scanner(System.in); // 학생 정보 키보드로 입력
		System.out.print("학번 :"); std.hakbun = sc.next(); 
		System.out.print("국어 :"); std.kor = sc.nextInt();
		System.out.print("영어 :"); std.eng = sc.nextInt();
		System.out.print("수학 :"); std.math = sc.nextInt();
	};
	
	
	void calc(Student1 std) { // 계산만 하는 메소드
		std.tot = std.kor + std.eng + std.math;
		std.avg = std.tot / 3.;
		std.grade = (std.avg >=90)? 'A': (std.avg >=80)? 'B' : 
						  	(std.avg >=70)? 'C': (std.avg >=60)? 'D':'F';
	};
	
	void output(Student1 std) { // 출력만 하는 메소드
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("-----------------------------------------");
		System.out.printf("%-10s%5d%5d%5d%5d%7.1f%3c%n",
				std.hakbun, std.kor, std.eng, std.math, std.tot, std.avg, std.grade);
		// -10 10칸인데, 왼쪽 정렬
	};
}
