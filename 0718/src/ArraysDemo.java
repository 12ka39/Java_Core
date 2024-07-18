import java.util.Arrays;
import java.util.List;

// Arrays.asList( ) 
//Arrays.sort()

public class ArraysDemo {
	public static void main(String[] args) {
		List <Integer> list =  Arrays.asList(4,6,8,1,2); // asList는 괄호 안에 있는 타입을 리스트화 시켜주는 메소드 (배열->리스트)
		List<String> list1 = Arrays.asList("한지민", "홍지민", "김지민");
		
		int [] array = {5,4,53,51,7,9,0};
		Arrays.sort(array); // sorting 해주는 메소드가 있음.  한계 -> 기본타입 1차원 배열 오름차순 정렬만 한다
		for (int a : array) System.out.print(a + ", ");
	}
}
