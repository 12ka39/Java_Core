import java.util.LinkedList;
import java.util.Queue;

// 큐. 큐는 인터페이스
// 자식 객체 (LinkedList) 로 만들어야 한다.
public class QueueDemo {

	public static void main(String[] args) {
		String[] array = {"한지민", "박지민", "홍지민", "한지민", "홍지민", "신지민", "곽지민"};
		Queue<String> queue = new LinkedList<String>();
		for (String element : array)  queue.add(element);
		System.out.println(queue); // [한지민, 박지민, 홍지민, 한지민, 홍지민, 신지민, 곽지민]
		// 큐는 들어간  순서대로 그대로 나온다. 
	}

}

