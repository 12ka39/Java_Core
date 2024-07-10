//조건문

import java.util.Scanner;

public class ConditionDemo {

	public static void main(String[] args) {
		//로직 에러 (로직에러는 잡기 쉽지 않다)
		//로직 에러는 경험에서 찾는다
		
		//이거 아무거나 입력해도 겨울: 동백, 매화 만 나온다. 
		// 왜? String 문자열은 참조형 변수라서 번지수 주소가 저장된다.
		// season은 번지수가 저장된 거
		// 그래서 문자열의 번지수 주소를 찾고 있는 거니까 비교해도 값이 항상 
		// else인 겨울: 동백, 매화만 나온다.
		System.out.println("Favorite Season(spring, summer, fall, winter): ");
		Scanner sc = new Scanner(System.in);
		String season = sc.nextLine();
		if(season == "spring") {
			System.out.println("봄: 개나리, 진달래");
		} else if(season == "summer") {
			System.out.println("여름: 장미, 아카시아");
		} else if (season == "fall") {
			System.out.println("가을 :백합, 코스모스");
		} else {
			System.out.println("겨울: 동백, 매화");
		}
		

		
		// 문자열 비교 (1) .equals()
		//               (2) .compareTo() == 0 
		// 
		//else if는 맞는 걸 찾아도 나머지 esle if까지 다 확인하고 지나가기 때문에 느리다
		// 코드 다 실행한다.
		// equals는 String class의 멤버 메소드이기 때문에, 주소가 필요하다. <- 이 부분 무슨 말인지 모르겠음
		
		
		if(season.equals("spring")) {
			System.out.println("봄: 개나리, 진달래");
		} else if(season.equals("summer")) {
			System.out.println("여름: 장미, 아카시아");
		} else if (season.compareTo("fall") == 0) { // 둘이 같으면 0을 리턴
			System.out.println("가을 :백합, 코스모스");
		} else {
			System.out.println("겨울: 동백, 매화");
		}
		
		
		// switch문은 해당되는 변수로 바로 넘어간다.
		// spring 입력하면 case spring으로 바로 간다.
		
		//switch문의 조건으로 char byte short int enum 등 올 수 있는 데이터 타입이 한정되어있음
		switch(season) {
			case "spring": System.out.println("봄: 개나리, 진달래"); break;
			case "summer": System.out.println("여름: 장미, 아카시아"); break;
			case "fall": System.out.println("가을 :백합, 코스모스"); break;
			default:  System.out.println("겨울: 동백, 매화");
		}
		
		
	}

}
