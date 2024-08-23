/* Stream API
 * 1. Stream : 배열이나 Collection 과 같은 여러 개의 데이터를 일관되게 처리하기 위해서 추가된 문법
 * 2. Data를 Stream으로 처리하기 위해서는 먼저 Stream 객체를 생성해야 한다.
 * 3. Stream API의 3가지 종류 (생성 - 중간 연산 - 최종 연산)
 * 		1) Stream 생성
 * 		2) 생성된 Stream을 가공하는 중간 연산 
 * 		3) 최종적으로 결과를 만드는 최종 연산
 * 
 * 4. 연산의 결과가 Stream으로 리턴되면 중간연산이라고 한다. 
 * 		반면 연산의 <결과가 Stream이 아닌 형태로 나타나면> <최종연산>이라고 한다.
 * 5. 중간 연산의 결과가 Stream으로 리턴되기 때문에, Stream 연산을 계속 이어서 chain 형태로 이용할 수 있다.
 * 6. But 최종 연산의 결과는 Stream이 아니기 때문에, 일단 최종 연산을 수행하면 다시 다른 Stream 연산을 수행할 수 없다.
 * 7. Stream 연산은 원본의 데이터를 읽어서 기능을 수행하지만, 그 내용을 변경하지는 않는다.
 * 
 * 국내 책에는 잘 안 나온다. 원서에 있음
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		// stream 생성 : (1) 배열 (2) Collection
		// API 문서 찾아가면서 배웠다
		
		// 배열로부터 Stream 생성하기 =>  Stream.of()
		Integer [] intArray = {1,2,3,4,5};
		Stream<Integer> s1 = Stream.of(intArray); // 스트림 배열 생성
		
		
		String [] strArray = {"사과", "배", "딸기", "복숭아", "레몬", "망고", "수박"};
		Stream<String> s2 = Stream.of(strArray);
		
		// Array를 객체화 -> Arrays
		// Arrays 으로부터 Stream 생성하기 => Arrays.stream()
		Stream<Integer> s3 = Arrays.stream(intArray);
		Stream<String> s4 = Arrays.stream(strArray);
		
		
		
		// Collection 으로부터 Stream 생성하기 - 각각의 컬렉션들은 stream을 가지고 있다   .stream
		
		//List
		List<String> list = Arrays.asList("사과", "배", "딸기", "복숭아", "레몬", "망고", "수박");
		Stream<String> s5 = list.stream(); //  각각의 컬렉션들은 stream을 가지고 있다
		
		List<Integer> list1 = Arrays.asList(3,5,2,5,6,7,6);
		Stream<Integer> s6 = list1.stream();

		//Set
		Set<String> set = new HashSet<String>(Arrays.asList("사과", "배", "딸기", "복숭아", "레몬", "망고", "수박"));
		Stream<String> s7 = set.stream();
	
	
		// 지정된 범위를 이용해서 Stream 생성하기
		// range(int startInclusive, int endExclusive) range(포함, 미포함)
		IntStream is = IntStream.range(1, 11); // 1~10
		DoubleStream ds = DoubleStream.of(10,5);
		
		
		
		// 난수를 발생하여 Stream 생성하기
		DoubleStream ds1 = new Random().doubles(15L, 1.0, 10.0); // 1부터 10까지 난수(실수) 15개 만들기
		IntStream is1 = new Random().ints(5, 1, 10); // 1부터 10까지 중 난수 5개 
		
	}

}
