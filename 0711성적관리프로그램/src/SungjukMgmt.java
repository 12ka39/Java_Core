import java.io.FileNotFoundException;


// 프로그램 완성한 뒤에는 main 함수가 있는 클래스 아니라
// 다른 클래스에서 실행해도, 알아서 main 함수 찾아서 실행한다 

public class SungjukMgmt { // 메인이 복잡할 수록 좋은 코드는 아님
	public static void main(String[] args) throws FileNotFoundException { // 메인으로 던져진 예외처리는 JVM 가상머신으로 던져짐
		Student [] array = new Student [12]; // 학생 12명 저장하는 수첩
		
		Input input = new Input(array); // 각 클래스에 12명 수첩 던져서 거기에 학생 정보 저장하도록
		input.input();
		
		Calc calc = new Calc(array); // calc 생성자 만들기 전데 여기서 먼저 이런 코드를 생성하면, 
				// 알아서 이클립스 툴이 생성자 코드 만들어준다. 오류 -> create constructor 
		calc.calc();
		
		Output output = new Output(array);
		output.output();
		
		System.out.println("Program is over.....!");
	}
}
