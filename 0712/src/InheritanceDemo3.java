// 4. 부모 생성자는 상속되지 않는다
// 자식 생성자는 반드시 부모의 기본 생성자'만' 호출한다

// super()는 자식 생성자에서 임의로 부모 생성자를 호출할 때 사용한다.
// 기본 부모 생성자는 생략 가능
// 반드시 생성자 안에서만 사용해야 하고, 생성자 안에서 반드시 첫번째 위치해야 한다

// 기본 생성자가 아닌 생성자를 사용하기 위해서는 super(a, b) 첫줄에 사용해야 한다
public class InheritanceDemo3 {

	public static void main(String[] args) {
		Sonata sonata = new Sonata("EF sonata", 30_000_000);
	}
}


class Car{
	String name;
	int price;
	
	public Car(String name) { // 부모 생성자
		this.name = name;
	}
}

class Sonata extends Car{
	int price;
	//public Sonata(int price) {this.price = price};
	public Sonata(String name, int price) { // 자식 생성자
		//자식 생성자가 부모의 기본 생성자가 아닌 생성자를 호출할 때 super(매개변수) 메소드
		super(name);
		this.price = price;
		//this 메소드와 super 메소드는 같이 사용할 수 없다.
		// 왜? 둘 다 생성자 맨 앞줄에 있어야 하니까. 둘 중 하나는 다르게 써야 한다
		 System.out.println(this.name);
		}
	}





final class Animal{ // final 클래스는 상속할 수 없다. 
}

// class Cat extends Animal{}   상속 불가

