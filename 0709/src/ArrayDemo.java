
public class ArrayDemo {

	public static void main(String[] args) {
		// ---정리 ---- 
		// int 배열은 0
		// double 배열은 0.0 
		// String 배열은 null 로 초기화
		
		int [] array = new int[4]; // 힙에 만들어지는 건 자동 초기화된다
		//	지역 변수만 자동 초기화x
		for(int i=0; i<4; i++) {
			System.out.printf("array[%d] = %d%n", i, array[i]);
			/*
			 array[0] = 0
			array[1] = 0
			array[2] = 0
			array[3] = 0
			 */
		}
		
		
		double [] array2 = new double[4]; // 힙에 만들어지는 건 자동 초기화된다
		//	지역 변수만 자동 초기화x
		for(int i=0; i<4; i++) {
			System.out.printf("array2[%d] = %f%n", i, array2[i]);
		}
		
		/*
		 array2[0] = 0.000000
		array2[1] = 0.000000
		array2[2] = 0.000000
		array2[3] = 0.000000 
		 */

		
		
		String [] array3 = new String[4]; // 힙에 만들어지는 건 자동 초기화된다
		//	지역 변수만 자동 초기화x
		for(int i=0; i<4; i++) {
			System.out.printf("array2[%d] = %s%n", i, array3[i]); // 
		}		
		/*
		 array2[0] = null
		array2[1] = null
		array2[2] = null
		array2[3] = null
		 */
		
}
}
