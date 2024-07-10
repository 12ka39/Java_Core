
public class SungjukMgmt {

	public static void main(String[] args) {
		Student yh = new Student();
		new Input().input(yh);
		new Calc().calc(yh);
		new Output().output(yh);
	}

}
