// Stream.reduce  누적할 때 많이 쓴다. 앞에거 더하기 뒤에거 더하기

import java.util.stream.IntStream;

public class StreamDemo2 {

	public static void main(String[] args) {

		// 1~100까지의 합 구하기
		// Stream의 reduce 함수 이용하기 
		
		IntStream is = IntStream.range(1, 101); // Stream 생성
		int total = is.reduce(0, (a,b)->a+b);  
							  //(초기값, 이항연산메소드(람다로 사용하자)) 
							  // 처음에는 a가 0이고, b가 1로 들어옴
							  // 그 다음에 a=1, b에 2가 들어온다.....
							  // 이 누적합이 total에 저장된다 
							 // 누적은 내가 코드 주는 게 아니라, 알아서 내부에서 돌아간다
		System.out.println(total); // 5050
		
	}

}
