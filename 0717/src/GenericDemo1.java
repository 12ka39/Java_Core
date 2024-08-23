import java.util.ArrayList;
import java.util.Vector;
/// 여기 이상함...............................
public class GenericDemo1 {

	public static void main(String[] args) {
		Object obj = "Hello"; // 자동형변환 가능하다.
		Vector<Object> v1 = new Vector<String>(); // 오류 나는 거 정상. 제너릭 세상에서는 형변환 안 된다. 왜냐고?
		// 제너릭은 타입읋 확실히 나누려고 만든거라, 타입 모호하게 형변환 허용하지 않는다
		
		Vector v2 = new Vector(); // raw type (Type  Erasure)
		 // 제너릭은 <> 없어도 된다.  raw type
		
		Vector<String> v3 = new Vector<String>();
		v3.add(5); // 오류 정상 String을 넣으려고 만들었는데, int를 넣어서 오류
		
		Vector<?> v4 = new Vector()<?>(); // wildcard type 런타임때 오브젝트로 바뀌는 타입이라고 생각한다
		v4.add(5);  // 여기 이상
		
		Product<Integer> pencil = new Product<Integer> (1000);
		Product<Double> ballpen = new Product<Double> (100.1234);
		//Product<Object> obj = new Product<Object> (new Car());
		
		//Car<Object> car1 = new Car<Integer>(1000); 이거 안 된다는 듯....??
		Car<?> car = new Car<Integer>(1000);
		Object ojb = car.getPrice();
		
		Car<? extends Number> car1 = new Car<Double>(10.0); //  extends Number 하한선
		Car<? super Number> car2 = new Car<Integer>(1000); //    super 상한선. 이거 안 됨. 인티저가 넘버의 자식이니까
		Car<? super Number> car3 = new Car<Object>(1000); //    super 상한선. 이거 안 됨. 인티저가 넘버의 자식이니까
		Object obj = car3.getPrice();
		// super인 경우에는 실체형을 따라가고,
		// extends인 경우에는 선언형을 따라간다.
		// ? 는 Object형을 따라간다.
		
		
		List<Car> list = new ArrayList<Car>(); // arraylist가 list로 형변환
	}
}

// List<T> 에서 List는 형변환 되지만, <T>는 형변환이 안 된다
//List 랑 <T> 따로 생각
class Car<T, U, V>{ // 제너릭 타입 매개변수가 여러 개다.....
	private T price;
	private U name;
	private V maker;
	
	public Car(T price, U name, V maker) {
		super();
		this.price = price;
		this.name = name;
		this.maker = maker;
	}
}

class Product<T extends Number>{ // 상한선을 정해주었다
	private T price;
	public Product(T price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.valueOf(price);
	}
}

class Product2<? super Number>{ // 상한선을 정해주었다
	private ? price;
	public Product2(? price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.valueOf(price);
	}
}