
public class OuterClass2 {

	public static void main(String[] args) {
		OuterClass2 oc = new OuterClass2();
		oc.display();
	}
	
	void display() {
		int a =5;  // local variable (로컬 변수)
		
		class InnerClass2{ // local class (로컬 클래스), 걍 변수라고 보자  -> 누군가 메소드를 호출해야 호출된다. 
			int b = 100; // local inner class's member variable 
			static int c = 500; // local inner class's static variable
			void print() {
				
		}
	}
		InnerClass2 ic = new InnerClass2();
		System.out.println(ic.b);    //왜? 멤버변수니까...   100
		System.out.println(InnerClass2.c);  //왜? 스태틱이니까...  500
	}}

