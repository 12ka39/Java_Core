package score_me;

import java.io.FileNotFoundException;

public class SungjukMgmt {

	public static void main(String[] args) throws FileNotFoundException {
		Student [] array = new Student[12];
		
		Input input = new Input(array);
		input.input();
		
		Calc calc = new Calc(array);
		calc.calc();
		
		Output output = new Output(array);
		output.output();
		
		System.out.println("Program is over........");
	}

}
