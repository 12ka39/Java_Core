/*
 * 동일 클래스에 있는 멤버 변수는 반드시 해당 클래스를 생성해서 그 주소로 접근해야 한다.
 * */
public class HelloWorld2 {
	String str ="Hello, World"; // instance | variable 멤버변수
	public static void main(String[] args) {
		HelloWorld2 hw = new HelloWorld2(); // 클래스 생성 후
		System.out.println(hw.str); // 멤버변수에 접근할 수 있다
		}
}
