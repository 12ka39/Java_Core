import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Hospital> list = new ArrayList<Hospital>(5);
		
		Input input = new Input();
		input.input();
		
		Calc calc = new Calc(list);
		calc.calc();
		
		Output output = new Output(list);
		output.output();
	}
}
