// 3. static 변수와 static 메소드는 상속되지 않는다
public class InheritanceDemo2 {

	public static void main(String[] args) {
		System.out.println(Student.age); // 객체 안 만들었는데 바로 사용할 수 있는 이유. static 변수라서
	}

}

class Person{
	String name = "한지민";
	static int age = 28; // 상속과 관련이 없음. static 은 객체와 상관없이 만들어진다
}

class Student extends Person{
	// name 만 상속받는다.
	// static 변수 age는 상속과 상관없다. 밖에 있는 놀이터라 그냥 가져다 쓸 수 있음
}