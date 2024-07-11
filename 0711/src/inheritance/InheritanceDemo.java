package inheritance;
// 상속
public class InheritanceDemo {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.새끼를낳다(); // 부모 메소드를 자식이 사용할 수 있다
		
		System.out.println(dog.name); // 오버 섀도우 변수는 상속되지 않는다
		// 우리 집(자식집)에 Tv가 있으면 굳이 부모 집에 가지 않는다
		 dog.print(); // 메소드가 같으면(오버라이드) 상속되지 않는다
		
		Cat cat = new Cat();
		cat.젖을먹이다(); // 부모 메소드를 자식이 사용할 수 있다
	}
}
