/*
 다른 클래스에 있는 멤버 변수는 속해 있는 클래스를 생성하고 그 주소로 접근한다  
 */

public class HelloWorld4 {
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.str); // static 변수는 클래스 이름으로 접근
	}

}

class Test{
	String str = "Hello World!"; // class | static variable 집 밖에 만들어진 놀이터
}