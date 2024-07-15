//추상 (abstract) 클래스 정리
/*
	abstract 클래스 -> 생성자, 게터세터, 변수, toString 모두 만들 수 있다
	
	interface 클래스 -> 0. 생성자, 게터세터, 변수, toString 만들 수 없다. 변수는 only 상수만 가능.

							  1. (public static final이 생략된) 상수만 가질 수 있다. (변수 가질 수 없다)
		             	      2. (public abstract 이 생략된) 추상 메소드만을 가질 수 있다 
 */

public abstract class Mammal { //  abstract 클래스 -> 생성자, 게터세터, 변수, toString 만들 수 있다
	private String name;
	private int age;
	

	public abstract void 새끼를낳다(); // 추상 클래스의 추상 메소드는 - 자식 클래스에서 무조건 재정의 해야 한다
	
	public Mammal(String name, int age) { 
		super();
		this.name = name;
		this.age = age;
	}


	@Override
	public String toString() {
		return String.format("Mammal [name=%s, age=%s]", name, age);
	}


	//게터 세터
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
}
