// 제너릭 -> 상자에 붙은 라벨이라고 보자
// 알아보기 쉽게 라벨 붙인 거

public class GenericDemo {

	public static void main(String[] args) {
/*		Car carnival = new Car(40_000_000);
		carnival.setPrice(45_000_000);
		System.out.println(carnival); // carnival.toString()
*/
		
		Car<Integer> carnival = new Car<Integer>(45_000_000); // Integer만 들어간 상자라고 '라벨'을 붙였다
		Car<String> matiz = new Car<String>("1000000"); // String만 들어간 상자
		Car<Double> sonata = new Car<Double>(45_000.1234); // Double만 들어간 상자
		System.out.printf("price = %d%n", carnival.getPrice()); // 오토박싱, 오토 언박싱으로 이해 ??
		System.out.printf("price = %s%n", matiz.getPrice()); 
		System.out.printf("price = %s%n", sonata.getPrice());
	}
}

// 자동차가 제너릭 타입이 된다
// int라고 썼던 부분이 T가 된 거다 -> T는 아무 타입을 다 받을 수 있다.  
//  class Car<T, U, V>{   그런게 3개 있음

class Car<T>{ // T 관례적으로 대문자 한 글자 (type) 이라고 한다.
	private T price;
	//private U name;
	//private V maker;
	
	public Car(T price) { this.price = price; } // 생성자

	public T getPrice() { return price; }
	public void setPrice(T price) { this.price = price; }
}
