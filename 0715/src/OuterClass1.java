
//member inner class

public class OuterClass1 {
	
	public static void main(String[] args) {
		OuterClass1.InnerClass1 ic = new OuterClass1.InnerClass1();
		ic.display(); // 10, 100, 500   (a 못 찍음)
		ic.print(); // 10, 500				(a,c 못 찍음)
	}
	
	private int a = 5;     //outer class's member variable
	private static int b = 10;   //outer class's static variable
	
	
	private static class InnerClass1{  //static inner class
		
		private int c = 100;     //static inner class's member variable
		private static int d = 500;  //static inner class's static variable
		
		public void display() {   //static inner class's member method
			System.out.println(b + ", " + c + ", " + d); // a는 접근이 안 된다.
		}
		
		public static void print() {    //static inner class's static method
			System.out.println(b + ", " + d);
		}
	}
}
