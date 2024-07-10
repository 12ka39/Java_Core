// 배열 복사 2가지 방법 
public class ArrayDemo3 {
	//교재 p217
	public static void main(String[] args) {
		// (1) 배열의 주소 복사 -->> 배열 1개 (변우민 1명)
		int [] original = {3,4,5};
		int [] target = original; // original의 주소를 target에 보내준다. 주소값 복사
										  // 같은 배열을 두 변수 모두 참조한다. (변우민을 장서희, 김서형이 바라봄)
										  // 힙 메모리의 한 배열을 두 변수 모두 참조한다.
										 // 배열 하나를 두 변수가 공유함.
										
		target[0] =100;          //target에서 값 변경하면
		System.out.println(original[0]); // 100  // original에서도 값 변경됨. 왜? 배열 하나를 같이 쓰고 있으니까
		
		
		// (2) 배열의 값 복사 -->> 배열 2개 (변우민 2명, 동명이인)
		int [] origin = {3,4,5};
		int [] tar = new int[10];
		tar[0] = origin[0];
		
		System.arraycopy(origin, 0, tar, 2, 2);
			// 원본배열, 복사할 항목의 시작 인덱스
			// 새 배열, 새 배열 시작 인덱스
			// 복사할 개수
			
		//System.arraycopy(origin, 0, tar, 9, 3); 자리가 모자라서 오류난다
		System.out.println(origin); // 두 주소 값이 서로 다르다.
		System.out.println(tar);
		
		System.out.println(origin[0]); // origin 자체는 참조하는 거니까 실제값 찍으려면 인덱스까지 찍어주자
	}

}
