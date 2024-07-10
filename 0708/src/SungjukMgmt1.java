import java.util.Scanner;

public class SungjukMgmt1 {

	public static void main(String[] args) {
		Student [] array = new Student[2]; // 배열은 길이 변경 안 됨. 처음 정해준 딱 2명만
			// 학생 2명의 정보가 들어갈 수첩을 만든거지,
			// '학생'을 만든 게 아니다. (사진 참조) - 학생을 만들려면 for문에서 -> array[i] = new Student(); // 학생 객체 생성
		
		Scanner sc = new Scanner(System.in);	
		for(int i=0; i<2; i++) {
			array[i] = new Student(); // 학생 객체 생성
			System.out.print("학번 : "); array[i].hakbun = sc.next();
			System.out.print("국어 : "); array[i].kor = sc.nextInt();
			System.out.print("영어 : "); array[i].eng = sc.nextInt();
			System.out.print("수학 : "); array[i].math = sc.nextInt();
			
			array[i].tot =  array[i].kor +  array[i].eng +  array[i].math;
			array[i].avg =  array[i].tot/3.;
		}

		for(int i=0; i<2; i++) {
			System.out.printf("%10s\t%5d\t%5d\t%5d\t%5d\t%10.1f%n",
					array[i].hakbun, array[i].kor, array[i].eng, array[i].math,
					array[i].tot, array[i].avg);
		}
	}

}
