import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 * 중간 연산 : filter() , map()
 * 최종 연산 : count(), sum(), max(), min(), average(), reduce(), forEach()
 * */

// stream.filter() , stream.map()
// 스트림 연산은 원본을 바꾸는 게 아니다
// filter(조건): 중간연산  - 조건에 맞는 것만 추출
// 근데 조건에 람다함수를 넣는다. 그래서 람다를 알아야 한다.



public class StreamDemo3 {

	public static void main(String[] args) {
		// 조건에 맞는 거 출력
		String [] array = {"abc", "Hello", "Hi~", "Java Language"};
		Stream<String> sStream = Stream.of(array); // 스트림 생성 : 배열은 Stream.of(array)
		// sStream.filter(str -> str.length() >= 5); // filter(조건)    str의 길이가 5글자보다 큰
		sStream.filter(str -> str.length() >= 5).forEach(s -> System.out.println(s + "\t"));
		
		
		
		
		// stream.map -> 중간연산. map은 값을 순회하면서 특정 값을 추출
		List<Customer> list = new ArrayList<Customer>(); // 방 만들고
		Customer c1 = new Customer("한지민", 28); list.add(c1); 
		Customer c2 = new Customer("김지민", 38); list.add(c2);
		Customer c3 = new Customer("박지민", 48); list.add(c3); 
		Customer c4 = new Customer("이지민", 58); list.add(c4); // 값 추가
		
		Stream<Customer> customerList = list.stream(); // 스트림 생성
		customerList.map(c -> c.getName()).forEach(s -> System.out.print(s + ",")); // 한지민,김지민,박지민,이지민,
		// c 이름을 찾아 각각 출력
 		
		
		
	}
}




class Customer{
	private String name;
	private int age;
	
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	
}