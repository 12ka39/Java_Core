//Hello World 찍는 8가지 방법
/*
 	동일 클래스에 있는 static 변수는 클래스 이름을 생략할 수 있다
 * 
 * */

public class HelloWorld1 {
	static String str ="Hello, World"; // class | static variable 집 밖에 만들어진 놀이터(공용공간)
	public static void main(String[] args) {
		//String str = "Hello, World"; //local | stack | auto | temporary variable
											// 지역변수는 스택에 올라감. 반드시 초기화 해야한다
		System.out.println(HelloWorld1.str); // 같은 클래스에 있을 땐 클래스명 생략 가능
		System.out.println(Demo.str); // static 변수는 클래스 이름으로 접근
	}
}

class Demo{
	static String str = "Python이 대세야!!!"; // class | static variable 집 밖에 만들어진 놀이터
}
