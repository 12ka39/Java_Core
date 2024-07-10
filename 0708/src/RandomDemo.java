
public class RandomDemo {

	public static void main(String[] args) {
		//1~10까지의 랜덤 넘버 추출
		// Math.random() 범위 0.0 이상 ~ 1.0 미만
		int rand = (int)(Math.random() * 10 +1);
		System.out.println("랜덤숫자" + rand);
		
		
		// switch문의 or 는 break로 제어한다
		switch(rand) {
			case 1: System.out.println("Bananas"); break;
			case 2: System.out.println("Oranges"); break;
			case 3: System.out.println("Peach");
				// case 3 or case 4 못 씀. || 도 못 씀-> break로 제어하자
			case 4: System.out.println("Apples");
			case 5: System.out.println("Plums"); break;
			case 6: System.out.println("Pineapples"); break;
			case 7: System.out.println(""); break;
			default: System.out.println("Nuts"); // 맨 위에 써도 되는데, 관례상 맨 아래에 쓴다.
		}
		
		}	
		
	}
	

	
	

