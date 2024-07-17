// java.util 패키지  
// 클래스로 시간을 찍는 6가지 방법

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTimeDemo {

	public static void main(String[] args) {
			
		// 방법1) Date - 근데 Date는 일부 기능이 deprecation 되어 있는 게 있음
		Date now = new Date();
		System.out.println(now); // Wed Jul 17 11:08:45 KST 2024

		
		// 방법2) Calendar (추상클래스) 연, 월, 일 
		// Calendar cal = new Calendar(); //캘린더는 추상 클래스라 객체 생성을 못 한다
		Calendar cal = Calendar.getInstance(); // 싱글톤.  getInstance()메소드를 이용한다.
		System.out.printf("오늘은 %d년 %d월 %d일입니다 %n",
				cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)); 
				// get메소드로 캘린더의 상수를 가져온다.
				cal.get(Calendar.DAY_OF_MONTH); // cal.get(Calendar.DATE) 랑 같은 거
	
			
		// 방법3) GregorianCalendar  (캘린더의 자식인 그레고리안을 이용) - 날짜 세팅을 할 수 있다.
		Calendar cal1 = new GregorianCalendar(2024, 11, 25);
		System.out.printf("올해는 %d년%n", cal1.get(Calendar.YEAR)); // 올해는 2024년
	
	
		// 방법4) DateFormat (추상클래스) - Locale
		DateFormat df = DateFormat.getDateTimeInstance(
				DateFormat.FULL, DateFormat.MEDIUM, Locale.FRANCE); // API문서 들어가보면 locale이 몇 개 없음
		System.out.printf(df.format(new Date())); // mercredi 17 juillet 2024, 11:33:09
		
		
		// 방법5) 포맷을 지정할 수 있다 p536 -> 많이 쓴다
		String pattern = "오늘은 yyyy년 MM월 dd일입니다";
		DateFormat df2 = new SimpleDateFormat(pattern);
		System.out.println(df2.format(new Date()));
		
		
		// 방법6) 가장 쉬운 방법
		String parttern2 = String.format("오늘은 %1$tY년 %1$tm월 %1$td일입니다", new Date()); // 첫 번째 거 1$
		System.out.println(parttern2); // 오늘을 2024년 07월 17일입니다
	}
	
	

}
