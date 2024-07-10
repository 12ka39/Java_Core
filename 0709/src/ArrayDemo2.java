// 다차원 배열 
public class ArrayDemo2 {

	public static void main(String[] args) {
		int [][] array; //2차원 배열 선언 --   int [] array [] ; 이렇게도 가능은 하다. 쓰는 사람은 없지만..
		array = new int[4][3]; // 2차원 배열의 생성, Rectangular Array 사각형 배열(각 층의 열의 개수가 같을 때)
		//array = new int[4][]; // 4층 짜리 집인데 각 층(열)에 몇 집이 사는지는 정해지지 않음. 층마다 달라질 수 있음. Jagged(Ragged) Array
		array[0][0] =5; // 할당 
		
		
		// 선언과 할당 동시에
		// 방법1) 
		int [][] intArray = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
		};
		
		
		// 방법2)  Rectangular Array
		int [][] intArray2; //선언
		intArray2 = new int[4][3]; // 생성
		intArray2[0] = new int[] {1,2,3}; // 1층 사는 사람들
		intArray2[1] = new int[] {4,5,6};
		intArray2[2] = new int[] {7,8,9};
		intArray2[3] = new int[] {10,11,12};
		
		
		
		// Jagged(Ragged) Array 층마다 열 개수가 다름
		int [][] intArray3;
		intArray3 = new int[4][];
		intArray3[0] = new int[] {1,2,3,4}; // 0층엔 방 4개
		intArray3[1] = new int[] {5,6}; 
		intArray3[2] = new int[] {7}; 
		intArray3[3] = new int[] {8,9,10,11,12}; 
		
		
		System.out.println(intArray3.length); // 4
		System.out.println(intArray3[3].length); //5
		
		//intArray3 의 요소들 찍기 (2차원 배열은 이중  for문 사용)
		for(int i=0; i<intArray3.length; i++) {
			for(int j=0; j<intArray3[i].length; j++) {
				System.out.printf("array[%d][%d] = %d\t", i, j, intArray3[i][j]);
			}
			System.out.println();
		}
		//double [] avg = {89.5}; // 초기화 
	}

}
