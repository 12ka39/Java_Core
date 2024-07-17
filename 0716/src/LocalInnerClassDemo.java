
public class LocalInnerClassDemo {
	public static void main(String[] args) {
		// InnerClass ic = new InnerClass();
		OutClass out = new OutClass();
		out.display();
	}
}

class OutClass{
	private int a =5; // outer class's member variable
	private static int b = 10; // outer class's static variable
	
	public void display() { 
		int c = 100; //local variable -  final이 생략되어 있음
		// 로컬 클래스는 메소드를 빠져나와도 객체 남아있을 경우가 있는데 (스레드)
		// 그 경우 이미 사라진 객체의 값을 변경하려고 하니까 오류가 난다. 
		
		class InnerClass{  //로컬 클래스
			public void print() {
				System.out.println(c); // a, b 도 가능
				// c = 1000; //  final이라 수정 불가해서 오류 남
			}
			
			
		}
		InnerClass ic = new InnerClass(); // 메소드가 끝나면 사라지는 객체
		ic.print();
	}
	
}
