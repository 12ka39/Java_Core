// 생성자
/*
 new 연산자 = 힙메모리 공간확보 
생성자 = 객체의 필드를 초기화 
 */

// 생성자는 필드 초기화를 한다. 

public class ConstrutorDemo {

	public static void main(String[] args) {
		Car sonata = new Car(); 
		System.out.println(sonata.getName()); // null -> 생성자가 자동으로 초기화 한다
		System.out.println(sonata.getPrice()); // 0
		
		Product pen = new Product();
		
		Product pencil = new Product("모나미 연필", 1000, "모나미사"); 
			//매개변수 순서, 타입이 생성자에 만들어진 거랑 일치해야 한다.
		
		Product computer = new Product("노트북", 25_000_000, "LG Gram");
		Product tv = new Product("텔레비전", 30_000_000, "삼성전자");
		
		
		/*  
		 
		<생성자> 는 리턴 타입이 없고, 
		클래스이름과 같아야 하고, 
		객체를 만들(생성할) 때' 만' 호출하는 메소드이다.
		
		교재 p247 (혼자 공부하는 자바)
		
		모든 클래스에 생성자가 있는데 API문서에 찾아보면
		Math 클래스에 생성자가 없다. 
		생성자가 안 보인다는 건 생성자를 private로 설정해둔 거
		
		기본 생성자를 숨겨둬서 사용할 수 없다.
		이런 클래스의 경우 대부분 멤버들이 static이다. 객체 생성 안 해도 바로 가져다 쓸 수 있도록..
		
		Scanner sc = new Scanner();
		스캐너 클래스도 이런 방식으로는 못 쓰는데, 이런 생성자를 숨겨두었기 때문
		 */
		
	}

}
