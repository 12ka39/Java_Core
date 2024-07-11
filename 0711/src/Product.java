
public class Product {
	String name;
	int price;
	String maker;
	
	// new 연산자 = 힙메모리 공간 확보 (땅 사기)

	// 생성자 = 객체의 필드를 초기화 하는 메소드
	
	
	
	// 생성자 오버로딩 
	
	// public Product(){}   이렇게만 쓰면 자동 초기화 됨. 아래 코드는
									// 이해를 위해 정확하게 적어둔 거
	public Product() { // 기본 생성자 Default constructor
		this.name = null;
		this.price = 0;
		this.maker = null;
	}
	
	
	
	public Product(String name, int price, String maker) { // 생성자
		this.name = name;
		this.price = price;
		this.maker = maker;		
	}
}
