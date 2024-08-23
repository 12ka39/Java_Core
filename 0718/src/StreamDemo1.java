import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamDemo1 {
	public static void main(String[] args) {
		DoubleStream ds = new Random().doubles(3L, 1.0, 10.0);
		ds.forEach(d->  System.out.println(d + ", "));

		int result = IntStream.rangeClosed(1, 100).sum(); //5050  for문 처리할 필요 없음
		// stream이 중간연산 최종연산을 한다고 한다..
		System.out.println(result);
	}

}
// 컬렉션을 소비해가면서 

//range.clode