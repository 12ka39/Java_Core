package interfaces;
// 비교 - Comparable <> 인터페이스
// sonata와 matiz 비교

public class InterfaceDemo1 {

	public static void main(String[] args) {
		Car sonata = new Car("EF소나타" , 30_000_000);
		Car matiz = new Car("RedMatiz" , 10_000_000);
		
		// sonata - matiz (내가 소나타, 파라미터가 마티즈)
		int result = sonata.compareTo(matiz);
		System.out.println(result); // 20000000uuuuuuuuuuuuuuu
	}
}


class Car implements Comparable<Car>{ // 비교 기능이 있는 Comparable 인터페이스를 사용하자
	private String name;
	private int price;
	
	
	
	
	@Override
	public String toString() {
		return String.format("Car [name=%s, price=%s]", name, price);
	}

	@Override
	public int compareTo(Car other) { // 내(car)가 other를 뺀다.  두 개를 비교해서 빼서 0이면 두 개가 같은거
		return this.price - other.price;  
	
	}
	
	
	public Car(String name, int price) {
		this.name = name;
		this.price = price;
	}


	
	
	
}