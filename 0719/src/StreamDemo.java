import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamDemo {

	public static void main(String[] args) {
		// Stream 쓰면 코드가 간단해진다.
		
		// rangeClosed
		int sum = IntStream.rangeClosed(1, 100).sum();
		long count = IntStream.rangeClosed(1, 100).count();
		
		System.out.println(sum + ", " + count); // 5050, 100

		//range : 101이 포함 안 됨. rangeClosed가 더 편하다
		int sum2 = IntStream.range(1, 101).sum(); 
		long count2 = IntStream.range(1, 101).count();
		
		
		System.out.println(sum2 + ", " + count2); // 5050, 100
		
		
		// 1.0 ~ 100.0까지 난수 15개 중 최댓값은?
		OptionalDouble max  = new Random().doubles(15L, 1.0, 100.0).max(); // 랜담값 뽑고 그 중 max
		System.out.println(max.getAsDouble());
		
		
	}

}
