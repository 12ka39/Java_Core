/*
 * Collection Framework 와 Lambda Expression
 * 컬렉션 프레임워크와 람다 표현식
 * */
// 여긴 오류 없다.
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo7 {

	public static void main(String[] args) { 
		List<Integer> list = Arrays.asList(4,6,1,4,7,8,3,2); // asList() 배열로 만든다.  
		List<String> list2 = Arrays.asList("한강", "두만강", "낙동강", "금강", "마", "하"); 
		// String은 빼기로 비교가 안 된다. 그래서 compareTo 로 비교한다. 36라인을 봐봐.

		// 1번째 방법
		Collections.sort(list, new Comparator<Integer>() { // 정렬

			@Override  // 툴에서 알아서 Override 하라고 뜬다.
			public int compare(Integer front, Integer back) {

				return front - back; // 오름차순
			} 
			
		});
		 System.out.println(list); // [1, 2, 3, 4, 4, 6, 7, 8]
		 
		 
		 // 2번째 - 람다 방법 (간결하다) 
		 Collections.sort(list, (front, back) -> front - back); // 오름차순
		 Collections.sort(list, (front, back) -> back - front); // 내림차순 [8, 7, 6, 4, 4, 3, 2, 1]
		 System.out.println(list);
		 
		 Collections.sort(list2, (front, back) -> front.compareTo(back));  // A.compareTo(B)
		 System.out.println(list2); // [금강, 낙동강, 두만강, 마, 하, 한강]
	}
}
