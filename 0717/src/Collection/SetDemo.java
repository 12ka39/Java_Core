// Set은 중복 없음, 순서 없음
// Set에는 HashSet 과 TreeSet이 있다. 
// TreeSet 은 정렬 된다

// add
package Collection;
// 컨트롤 + 쉬프트 + o -> 자동 임포트

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		String [] array = {"한지민", "박지민", "홍지민", "한지민", "홍지민", "신지민", "곽지민"};
		Set<String> hashset = new HashSet<String>(); // hashset 선언 (방 만들기)
		Set<String> treeset = new TreeSet<String>();  // treeset 선언
		
		for(String element : array) {
			hashset.add(element);  // 값 넣기
			treeset.add(element);
		}
		
		//set은 중복 허용X
		//hashset은 그냥 보여주고
		//treeset은 sorting을 한다
		System.out.println("Hashset = " + hashset);
		System.out.println("Treeset = " + treeset);
	}
}