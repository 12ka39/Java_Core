import java.util.Arrays;
import java.util.List;
//람다로 list에 저장된 각 element 출력하는 법 
public class LambdaDemo8 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("사과", "배", "딸기", "복숭아", "레몬", "망고", "수박");
		//list에 저장된 각 element를 iterate해서 출력하기
		
		// 1st way -> 늘 하던 방법
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i) + ", ");
		}
		
		System.out.println();
		
		//2nd way -> 향상된 for문.
		for (String str : list) System.out.println(str + ", ");
		
		System.out.println();
		
		// iterator가 내부적으로 돈다고 한다
		
		
		//3rd way (파라미터에 람다를 사용한다) - 앞으로 이걸 자주 사용할 거라고 한다
		list.forEach(str -> System.out.println(str + ", "));
	}
}
