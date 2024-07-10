/*
 * 다른 클래스의 멤버 메소드는 클래스를 생성하고 그 주소로 접근한다
 * */
public class HelloWorld8 {

	public static void main(String[] args) {
		new Car().print(); // static 메소드가 아니니까 클래스 객체 생성하고 가져온다.
	}
}

class Car{
	void print() { // member | instance method
		System.out.println("Hello World!");
	}

}