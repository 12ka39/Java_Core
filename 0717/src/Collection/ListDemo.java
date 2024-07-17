package Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//List 중복 허용, 인덱스로 접근 - Vector, ArrayList, LinkedList
// 배열과 달리, 길이를 자유롭게 늘리고 줄일 수 있다.
// add, remove

public class ListDemo {

	public static void main(String[] args) {
		
		// 벡터는 ArrayList 나오기 전까지 많이 사용했다
		Vector<String> vector = new Vector<String>(5,3); // (초기사이즈, 증가사이즈)
		//vector는 증가량도 조절할 수 있다. 메모리를 아낄 수 있다.
		
		///////////////////////////////////////////////////////////////////
		
		// ArrayList
		String[] array = {"한지민", "박지민", "홍지민", "한지민", "홍지민", "신지민", "곽지민"};
		List<String> list = new ArrayList<String>(); // 방 10개 생성.  디폴트 생성자는 10개
		List<String> list2 = new ArrayList<String>(5); // 처음에 5개로 만들고 싶으면 이렇게
		for (String element : array ) {
			list2.add(element);
		}
		System.out.println("현재 방 개수는 : " + list2.size()); // 현재 방 개수는 : 7
		System.out.println(list2); // [한지민, 박지민, 홍지민, 한지민, 홍지민, 신지민, 곽지민]
		
		list2.remove(0); // 0번째 제거 
		System.out.println(list2); // [박지민, 홍지민, 한지민, 홍지민, 신지민, 곽지민]
		
		
		
	}

}
