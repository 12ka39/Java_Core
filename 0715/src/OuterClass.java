//member inner class

public class OuterClass {

	public static void main(String[] args) {
	
		OuterClass oc = new OuterClass();    
		OuterClass.InnerClass ic = oc.new InnerClass(); // 중요. 이너 클래스는 이렇게 생성한다.

		System.out.println(ic.c);
		System.out.println(InnerClass.d);   //static
		
		ic.display(); // 5, 10, 100, 500
		ic.print(); // 500  (a, b, c 못 찍음)
	
	}
	
	private int a = 5;     //outer class's member variable - 멤버 변수
	private static int b = 10;   //outer class's static variable - static 변수
	
	
	private class InnerClass{  //member inner class  - OuterClass 클래스의 멤버 클래스.
		
		private int c = 100;     //inner class's member variable
		private static int d = 500;  //inner class's static variable
		
		public void display() {   //inner class's member method
			System.out.println(a + ", " + b + ", " + c + ", " + d) ;  // a가 찍히는 이유?
		}
	
		public static void print() {  
			System.out.println(d);   //inner class's static method  
		}
	}
}
