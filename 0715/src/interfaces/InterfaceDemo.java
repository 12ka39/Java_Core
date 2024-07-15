package interfaces;

public class InterfaceDemo {

	public static void main(String[] args) {
		//5. interface도 추상클래스처럼 인스턴스화(객체 생성)가 안 된다.

		// 선언형 부모형 = 실체형은 자식형 (다형성)
		Mammal1 m = new Dog();   m.display();
		Mammal1 m1 = new Cat();  m1.display();
		System.out.println(Mammal1.PI); // 상수여서 객체 생성 안 하고 바로 접근 가능
		// Mammal1.PI = 3.15;   // 상수 값 변경 불가
		
		//다형성이 가능하니까 헤테로 지니어스 컬렉션이 되니까 
		// 포유류(Mammal1)인데 그 안에 고양이, 개 다 넣을 수 있음
		// Mammal1은 일종의 만능 리모컨이다. 아무 기계나 다 켜고 끌 수 있음
		
		Mammal1 [] array = new Mammal1[2]; // 선언만 했음. 방 만들기
		array[0] = new Dog(); // 객체 생성
		array[1] = new Cat(); // 객체 생성
		for(Mammal1 ma : array)  ma.display();
		
		
		Mammal1 [] array2 = new Mammal1[2]; // 선언만 했음. 방 만들기
		array2[0] = new Dog();
		array2[1] = new Cat();
		for (Mammal1 ma2 : array2) {
			ma2.display();
		}
		
		
	}

}








// 3. interface 구현 시 implements 키워드 사용해야 한다. (extends 아님)
class Dog implements Mammal1{

	// 4. interface 추상 메소드를 재정의시 반드시 public 이어야 한다
	// 왜냐? 부모의 추상 메소드가 public이니까 더 범위를 줄일 수가 없음.

	@Override
	public void display() { // 추상 메소드 범위가 public이
		System.out.println("개에 맞게 재정의된 메소드");
	} 
}


class Cat implements Mammal1{
	@Override
	public void display() {
		System.out.println("고양이에 맞게 재정의된 메소드");
	}
	
}








