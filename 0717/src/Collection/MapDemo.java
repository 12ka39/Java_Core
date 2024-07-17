package Collection;

import java.util.Date;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class MapDemo {

	public static void main(String[] args) {
		Date now = new Date(); 
		System.out.println(now); // Wed Jul 17 15:37:36 KST 2024
		
		String nowStr = now.toString(); // 날짜를 문자열로 바꿨음

		// 문자열 Parsing 방법 3가지
		// 1. String class's split()         String [] array = split(String regrex) <- 정규식 
		// 2. Scanner class's useDelimeter()    new Scanner(문자열).useDelemeter(String regrex)
		
		// 3. StringTokenizer class 
		
		//The string tokenizer class allows an application to break a string into tokens
		// string을 token으로 잘라준다
		StringTokenizer st = new StringTokenizer(nowStr); // 공백을 만나면 알아서 잘라줌
		// Wed Jul 17 15:38:10 KST 2024 이걸 공백으로 잘라줌
		
		/*
		while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken()); // return 타입이 String이라 int  필요하면 ParseInt 해야함
	     }
		*/
		
		String [] array = new String[st.countTokens()] ; // 배열 선언. st.countTokens()의 길이만큼
		for(int i=0; i<array.length; i++) {
			array[i] = st.nextToken();
			//System.out.println(st.nextToken());
		}
		System.out.print("오늘은 " + array[5] + "년 "); 
		System.out.println( getMonthbyName(array[1]) + "월 " + array[2] + "일입니다.");
		// 여기서 월이 July로 영어로 찍혀서 이걸 숫자로 바꿔줄 메소드를 추가해줘야 한다.
		// 왜 이렇게 생겨먹었는지는 모름
		

		//getMonthbyName() 사용자 정의함수
	}
	static int getMonthbyName(String month) {
		//hashMap, hashTable
		// hash는 put으로 데이터 넣고, get으로 가져온다
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		ht.put("Jan", 1);   ht.put("Feb", 2);   ht.put("Mar", 3);  ht.put("Apr", 4);
		ht.put("May", 5);   ht.put("Jun", 6);   ht.put("Jul", 7);  ht.put("Aug", 8);
		ht.put("Sep", 9);   ht.put("Oct", 10);   ht.put("Nov", 11);  ht.put("Dec", 12);
		return ht.get(month);
	}		
}