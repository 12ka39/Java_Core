

// Stream 주의점!! ---> 
/*
 *  java.lang.IllegalStateException 발생 이유
 * 		1. 한 번 사용한 Stream은 재사용할 수 없는 '일회성 객체'이기 때문이다.
 * 		2. 따라서 필요하다면 다시 생성해야 한다.
 * 
 * // 한 번 쓴 스트림은 소멸된다
	// 컴파일 오류는 안 나고, 런타임 오류가 난다
 * */

import java.util.Random;
import java.util.stream.IntStream;

public class StreamDemo1 {

	public static void main(String[] args) {
		IntStream is = IntStream.rangeClosed(1, 100); // Stream 생성
		int sum = is.sum(); // 최종연산 (스트림 소진. 더 이상 다르연산 불가)
		
		//최종 연산 후 스트림이 소진된다. (컴파일 에러는 X, 런타임 에러 뜬다)
		//long count = is.count(); // 오류 IllegalStateException : stream has already been operated upon or closed
	
	
		// 1부터 100 사이에 난수를 발생하여 중복을 배제하고 5개를 추출하여 sorting 까지 수행하자 
		// -> 중간연산(연산 결과가 Stream이면)을 계속 반복하면 
		
		// 리턴타입을 보면서 중간연산인지 아닌지를 확인하자
		// 리턴타입이 Stream이면 (중간연산) 계속 사용할 수 있다
		IntStream sortedInt = new Random().ints(1, 100).distinct().limit(5).sorted(); // 1~100사이의 난수 발생, 중복 제거, 5개 추출, 정렬
		sortedInt.forEach(i -> System.out.println(i + ","));
		
	
	
	}
	
	
	

}
