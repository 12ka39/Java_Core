// 상속되지 않는 4가지 경우
// 1. 오버섀도우 변수, override 메소드는 상속되지 않는다.
// 2. private 멤버는 상속되지 않는다
// 3. static 변수와 static 메소드는 상속되지 않는다

// 4. 부모 생성자는 상속되지 않는다
// 자식 생성자는 반드시 부모의 기본 생성자'만' 호출한다
// super()는 자식 생성자에서 임의로 부모 생성자를 호출할 때 사용한다
// 반드시 생성자 안에서만 사용해야 하고, 생성자 안에서 반드시 첫번째 위치해야 한다

public class InheritanceDemo extends Object{  // 모든 객체는 Object의 자식이다

	public static void main(String[] args) {
		Horse h = new Horse();  
		h.display(); // 오버라이드 메소드
		System.out.println(h.toString()); // Horse@28a418fc <- 이건 toString() 재정의 전 결과.
			// 자기클래스명 @ 해시코드 (JVM이 관리하는 말이 저장된 메모리 주소) 
	}
}

// 최상위 객체가 Object ->> Mammal ->> Horse
// 각각 하나의 부모만 상속받기 때문에
// Horse는 Mammal 하나만 상속 받는다. Object는 부모로 상속받지 못한다. Object는 부모가 아니라 할머니!!! 

class Mammal extends Object{ // 부모
	public void display() {
		System.out.println("나는 포유류");
	}
}

class Horse extends Mammal { // 자식
	
	@Override // 컴파일러에게 재정의 했다고 알려주는 어노테이션. 안 써도 되는데 컴파일러 인식하게 하려고 써주었다
	public void display() { // 부모 메소드와 시그니처 일치 (리턴타입, 이름, 매개변수 목록) : 부모 메소드 오버 라이딩
		super.display(); // 부모님의 display 메소드 찍기
		System.out.println("나는 제주 말이야. (부모 메소드 오버 라이딩)");
	}	
	
	
	
	// 이거 모르겠음.
	@Override
	public String toString() { //Object 메소드 재정의
		super.toString(); // ??? 왜 오브젝트 클래스 super 못 불러옴? -> 못 불러오는 게 아니라 print로 찍어야 결과 볼 수 있음
		System.out.println(super.toString()); // super.toString() 잘 실행되는 걸 볼 수 있다.
		return "toString() 나는 제주 말입니다~~~";
	}
}



