// 익명객체
// 1) 상속 받아서 만든 익명 객체 

public class AnnonymousClassDemo {
	public static void main(String[] args) {
//		Canine ca = new Dog();  // 정상적으로 객체 사용하는 방법
//		ca.roam();
//		ca.bark();
		
		Canine ca = new Canine() { // 일회성 객체.  Canine을 만든 게 아니라  Canine의 자식을 만든 거다!
			
			@Override
			void bark() {
				System.out.println("우르렁 짖다");
			}
			
			void display() { // 익명 객체 내부에 정의한 메소드
				System.out.println("메소드");
			}
			
		}; // 세미콜론 잊지 말자. 이게 한 라인의 끝이다. (익명객체 끝)
		
		ca.bark();
		ca.roam();
		
		//ca.display(); 
		// 익명 객체 내부에 정의한 메소드는 외부에서 사용할 수 없다. 교재 449페이지.
	}
}




abstract class Canine{ // 개과 
	
	abstract void bark();
	void roam() {
		System.out.println("여기저기 배회하다");
	}
	
}

/*
class Dog extends Canine{ 
	void bark() {
		System.out.println("우르렁 짖다.");
	}
}
*/



