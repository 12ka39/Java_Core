// 2. private 멤버는 상속되지 않는다
public class InheritanceDemo1 {

	public static void main(String[] args) {
		Frog f = new Frog();
		// f.name = "개구리";  사용 못 함

	}

}


class 양서류{
	private String name; // private는 자식에게도 상속하지 않는다
		// private는 자기 클래스에서만 사용할 수 있다.
	int weight;
}


class Frog extends 양서류{
	
}
