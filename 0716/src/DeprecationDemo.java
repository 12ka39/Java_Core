import java.util.Date;

public class DeprecationDemo {

	public static void main(String[] args) {
		Date today = new Date(); // 캘린더 클래스가 나오기 전까지는 Date 클래스를 썼다고 한다
		 System.out.println(today); // today.toString()
		 int year = today.getYear();  // 에러가 아니다. 요즘 안 쓰는 거라고 알려주는 뜻.
		 System.out.println(year); // 124
		 System.out.println(year + 1900); // 2024
		 
		 // 자바에서는 원년이 2개 있는데 그 중 하나가 1900년 -> 그래서 2024라 124가 나온다
		 // Date클래스 요즘은 안 쓴다. 1.0버전에 Date가 나오고 1.1버전에 Calendar 가 나왔다
		 // 라이브 스크립트 -> 자바 스크립트  (마케팅 목적으로) 로 이름 바꿈
		 // 
	}
}
