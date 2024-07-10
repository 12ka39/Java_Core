// Call by Value
public class CallbyRefDemo {

	public static void main(String[] args) {
		CallbyRefDemo d = new CallbyRefDemo();
		int money = 10000;
		String name = "한지민";
		System.out.printf("Before money = %d, name = %s%n", money, name );
		
		d.change(money, name);
		System.out.printf("After money = %d, name = %s%n", money, name );
		// int는 primitive라 call by value 라 값 안 바뀐다고 해도 String도 안 바뀌는 이유?
		// 자바 String - 불변값
		// 만약 문자열을 바꾸면 다른 번지에 바뀐 문자열이 생긴다
		// String의 불변값을 가변으로 바꾸려면 String 버퍼를 사용해야 한다
	}
	
	void change(int su, String str) { // 멤버 메소드 (static 이 없는)
		su *= 5;
		str = "김지민";
		System.out.printf("In change() su = %d, str = %s%n", su, str );
		//메소드 안에서는 값이 바뀌지만, 
		//다시 돌아간 11번 라인 출력 결과는 변하지 않는 걸 확인할 수 있다.
		
	}

}
