// enum

/**
 *@author N
 *@version 1.0.0
 *@since jdk 17
 * 
 * */

public enum Season { // public static final이 생략되어 있다. (인터페이스랑 같다)

	// enum은 enum 상수가 맨 처음에 와야 한다. 생성자 먼저 못 적는다
	
	spring(5), summer(100), fall(1000), 
	winter(30_000_000); // 숫자를 생성자라고 생각한다 (지금 숫자 생성자가 들어온 거)
	
	private int value;
	Season(int value) { // 생성자. public 못 붙인다
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}

	// 나열형은 문자열이 아니고 걍 spring은 spring이다