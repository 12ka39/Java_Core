// 초기화 블록

//초기화 블록과 생성자

public class InitializationBlock {
	private double weight;
	private char grade;
	
	/* <초기화 블록>
	 * 
		객체 생성할 때 딱 한번 자동 수행되는 블록이다
		생성자보다도 먼저 실행된다
		이름이 없기 때문에 값을 나중에 바꿀 방법이 없다
		
	 */
	{ // 초기화 블록
		this.weight = 100.0; // 초기화 블록 먼저 실행되고, 그 다음에 생성자가 호출된다
		this.grade = 'F';
		System.out.println("나는 초기화 블록~~"); // 초기화 블록 먼저 생성하고 
	}
	
	public InitializationBlock() { // default constructor's overriding 기본 생성자 오버라이딩
		System.out.println("나는 생성자"); // 그 다음에 생성자가 실행된다
		this.weight = 62.4; // 100으로 된 값에 62.4가 덮어 씌워진다.
		this.grade = 'C';
	}
	
	public static void main(String[] args) {
		InitializationBlock jimin = new InitializationBlock(); // 객체 생성
		System.out.println(jimin.weight + "kg"); // 처음에 100이었다가 62.4로 바뀜
		System.out.println(jimin.grade); // c
	}
}
