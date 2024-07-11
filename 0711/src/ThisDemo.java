// this의 3가지 용법

/*
 	1. this.   : 나의 주소
 	2. this    :  나
 	3. this() :  나의 생성자
 * *
 */
public class ThisDemo {

	public static void main(String[] args) {
		Car sonata = new Car(); // sonata 객체 주소 저장됨 = 이게 this
		sonata.setName("현대소나타");
		sonata.setPrice(30_000_000);
		
		System.out.println("이름 = " + sonata.getName());
		
		Car matiz = sonata.clone(); // 주소 복사. matiz에 Car 클래스 주소 저장됨
			// 주소 넘어왔으니까 권한 넘어옴
		System.out.println(matiz.getName()); // 현대 소나타
			//matiz가 Car 객체의 주소 가리키니까 참조변수는 
	}
}

