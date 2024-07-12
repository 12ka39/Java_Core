
public class OverrideDemo {
	public static void main(String[] args) {
		Base parent = new Derived();  
		parent.display();
		
		//Object obj = new String("Hello, World");
		
		
	}
}

// public > protected > default > private
/*
 	Override 된 자식 메소드의 접근 범위는 부모 메소드보다 같거나 더 넓어야 한다.
 */
class Base{
	void display() { // 접근 범위-> default 인데 자식 접근 범위가 더 작을 수 없다.
		System.out.println("나의 부모 메서드");
	}
}

class Derived extends Base{
	@Override
	public void display() { // 공개범위 -> public 가능. 근데 부모보다 범위를 더 줄일 수는 없다.
									// private, protected 면 오류
		System.out.println("나의 자식 메서드");
	}
	
}
