
public class OverloadingDemo {

	public static void main(String[] args) { //main이 static인 이유 -> 주소 없이 접근하려고

	}
	
	void change(){};
	//지역변수 명은 오버로딩에 영향 주지 않는다
	void change(int a){};
	void change(int b, String name){}; // 매개변수 순서도 오버로딩에 영향을 준다
	void change(String name, int b){};
	
	
	void change(short a){};
	void change(double a){};
}
