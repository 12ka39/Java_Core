
public class EnumDemo {

	public static void main(String[] args) {
		// Seanson seaon = new Season(); // enum은 new를 쓸 수 없다
		Season season = Season.fall;
		System.out.println(season); // fall
		
		System.out.println(season.ordinal()); 
				// enum 타입의 순서(인덱스)가 몇 번째인지 알아보려면
				// .ordinal() 을 쓴다. (api 문서에 있음)
		
		System.out.println(season.getValue()); // 1000
		
	}

}
