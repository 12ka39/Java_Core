/*
 	* Child : String
 	* Parent : Object
 
 * */
public class PolymorphismDemo1 {
	public static void main(String[] args) {
		String str = "Hello, World";
		Object original = str; // 자식이 부모형으로 자동 형변환
		
		if(original instanceof String) System.out.println("된다");
		else System.out.println("안된다");
		
		String target = (String) original; // 부모가 자식으로 강제 형변환
		System.out.println(target);
		
		//////////////////////////
		Parent jimin = new Parent();  
		Child hee = new Child();  
		
		System.out.println(jimin.toString());  // Parent@28a418fc
		System.out.println(hee.toString());    // Child@28a418fc
		
		jimin = hee; // 자동형변환  - 자식 hee의 주소가 jimin에게 넘어간다
		
		System.out.println(jimin.toString()); // Child@28a418fc
		
		jimin.display(); // 나는 자식 메소드. 부모님 타입인데 자식 주소로 자식의 메소드를 사용 -> 다형성
		//부모 타입으로(jimin) 접근하는데, 자식 메소드 display() 에 접근
		
	}
	
}


class Parent{
	public void display() {System.out.println("나는 부모 메소드");}
}


class Child extends Parent{
	@Override //메소드 재정의
	public void display() {System.out.println("나는 자식 메소드");}
}
