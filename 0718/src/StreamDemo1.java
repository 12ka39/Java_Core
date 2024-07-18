import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamDemo1 {
	public static void main(String[] args) {
		DoubleStream ds = new Random().doubles(3L, 1.0, 10.0);
		ds.forEach(d->  System.out.println(d + ", "));

		int result = IntStream.rangeClosed(1, 100).sum();
		System.out.println(result);
	}

}
// 컬렉션을 소비해가면서 

//range.clode