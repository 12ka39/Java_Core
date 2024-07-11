// this 용법 3번째
// 	3. this() :  나의 생성자 
public class ThisDemo1 {

	public static void main(String[] args) {
		Employee min = new Employee();
		System.out.printf("%.1f원", min.salary);
		// min 객체 생성했을 때 new Employee(); 생성자에 아무것도 넘겨준 게 없는데
		// 10000000.0원 이렇게 뜨는 이유.
		// 기본 생성자에서 this로 또 다른 생성자를 호출했기 때문
	}

}
