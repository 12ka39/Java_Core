package inheritance;

//자식 클래스 - 개
public class Dog extends Mammal {
	
	// 정리 -> 변수의 이름이 같거나 메소드 이름이 같으면 상속되지 않는다.
	
	public String name = "나는 개~!"; // 변수의 이름이 같으면 오버섀도우 변수.
		// 오버 섀도우 변수는 상속되지 않는다
		// 우리 집(자식집)에 Tv가 있으면 굳이 부모 집에 가지 않는다
	
	public void print() { // 메소드가 같으면 상속되지 않는다. 
		System.out.println("나는 개다...");
	}
	
	public void bark() {
		System.out.println("짖다");
	}
}
