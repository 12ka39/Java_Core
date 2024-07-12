// Heterogeneous(여러 다른 종류들로 이뤄진) Collection
// 헤테로 지니어스 컬렉션

public class PolymorphismDemo3 {
	public static void main(String[] args) {
		Dog [] dogArray = new Dog[3];  // 개 배열
		// dogArray[0] = new Cat(); // 오류. 개 배열에는 개만 들어가야 한다.
		
		// 부모가 같으면 다 묶을 수 있다
		Poyuryu [] array = new Poyuryu[4];  // 포유류 배열
		array[0] = new Dog();	// 개, 사람 모두 들어갈 수 있다
		array[1] = new Cat();
		array[2] = new American();
		array[3] = new Korean();
		
		for (Poyuryu m : array) {
			m.sayThing();
		}
	
	}
	
}


