package interfaces;
// 인터페이스 

public class InterfaceDemo2 {
	public static void main(String[] args) {
		Product pencil = new Product("모나미연필");
		Product ballpen = pencil; // ''주소'' 복사. pencil, ballpen 모두 같은 객체를 가리킨다
		System.out.println(ballpen.name); // 모나미연필
		
		// <값 복사>
		// ballpen.clone(); // clone()이 protected라서 자기 패키지와 자식만 사용할 수 있다
		Product ballpen1 = pencil.copy();  // ''값'' 복사 -> 근데 에러 난다 '복제 안 됨.' 왜?????
		// 복제 능력이 없어서. 그래서 implements Cloneable 복제능력 붙여준다.
		// 다행히 Cloneable 에 재정의해줘야 하는 멤버 메소드 같은 게 없어서 메소드 재정의할 필요 없음
		System.out.println(ballpen1.name); // 모나미연필
		
		pencil.name="컴퓨터"; // 값 복사는 이렇게 했을 때 다른 객체 영향 안 줌
		System.out.println(ballpen1.name); // 모나미연필 (결과 안 바뀜)
	}

}



class Product extends Object implements Cloneable{ // flag interface        implements Cloneable 복제 능력 추가
	String name;

	public Product(String name) { this.name = name; }
	
	public Product copy () {
		Product target = null;
		try {
				Object obj  = this.clone(); // 나는 복제해서 target에 넣자
				if (obj instanceof Product) target = (Product) obj;
				else System.out.println("형변환 안 됨");
				
		} catch (CloneNotSupportedException e) { 
			 System.out.println("복제 안 됨");
		}
		return target;
	}
	

}