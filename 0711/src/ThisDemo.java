// this의 3가지 용법

/*
 	1. this.   : 나의 주소
 	2. this    :  나   (대명사)
 	3. this() :  나의 생성자
 * *
 */
public class ThisDemo {

	public static void main(String[] args) {
		Car sonata = new Car(); // sonata에 객체 주소 저장됨 = 이게 this
		
		sonata.setName("현대소나타"); // sonata 객체에 이름, 가격 세팅하기.
		sonata.setPrice(30_000_000);
		
		System.out.println("이름 = " + sonata.getName()); // 이름 = 현대소나타
		
		
		Car matiz = sonata.clone(); // 주소 복사. matiz에 Car 클래스 주소 저장됨
			// 참조타입인데, 주소 넘어왔으니까 권한 넘어옴!!
		
		System.out.println(matiz.getName()); // 현대 소나타
			//matiz의 주소 =  sonata 주소 
		
		matiz.setName("랜드로버");
		System.out.println(sonata.getName()); //랜드로버
	}
}

