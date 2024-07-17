package Collection;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
//ve si 벳시 로 외우자
// Set -> Iterator 
// Vector -> Enumeration
public class CollectionDemo {

	public static void main(String[] args) {
		String[] array = {"한지민", "박지민", "홍지민", "한지민", "홍지민", "신지민", "곽지민"};
		
		//bulk로 데이터를 추출하고자 할 때 Enumeration, Iterator
		// Set -> Iterator  ,  Vector -> Enumeration
		
		Set<String> set = new HashSet<String>();
		for (String element : array) set.add(element);
		
		// Iterator
		Iterator<String> iters =  set.iterator(); // iterator() - Returns an iterator over the elements in this set
		while(iters.hasNext()) { // 다음 element가 있다면, (지금 몇 개 인지 모르니까 while)
			System.out.print(iters.next() + ","); // 한지민,홍지민,신지민,박지민,곽지민,
		}
		
		System.out.println(); /////////////////////////////////////////////////////
		
		// Enumeration
		// 예전엔 벡터를 사용했는데 이터레이터를 사용하면서 잘 안 쓰는 듯
		Vector<String> vector = new Vector<String>();
		for (String element : array)  vector.add(element);
		Enumeration<String> enums = vector.elements();
		while(enums.hasMoreElements()) { // elements가 더 있으면 true
			System.out.print(enums.nextElement() + ",");
		}
	}

}
