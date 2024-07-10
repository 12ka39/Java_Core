// 향상된 for문 - Enhanced For
public class ArrayDemo4 {

	public static void main(String[] args) {
		double [] array = {3.14, 89.5, 182.5};
		for(int i=0; i<array.length; i++) {
			System.out.printf("%.2f%n", array[i]);
		}
		
		System.out.println("------------");
		
		// 기존 for문은 정확한 반복 횟수를 알아야한다는 단점이 있음
		
		//Enhanced For -> 반복횟수 몰라도 됨
		// for 라고 치고 ctrl + 스페이스 -> foreach 선택
		
		for (double d : array) {
			System.out.println(d);
		}
		
	}

}
