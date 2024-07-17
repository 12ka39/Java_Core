// Exception을 나를 호출한 메소드에 던진다

// 메소드가 호출되면서 스택에 복귀 주소를 저장한 다음,
// 돌아올 때 그 복귀 주소를 타고 오는데,
// 스택에서 일어나기 때문에 printStactTrace(); 
// 그래서 try-catch할 때 스택으로 잡는다  ( e.printStackTrace() )

public class ExceptionDemo2 {
	public static void main(String[] args) {
		a();
	}
	
	static void a() {
		b();
	}

	static void b() {
		try{
			c();
		}catch (ArithmeticException e){
			System.out.println("여기서 잡았음");
		}
	}	
	
	static void c() {
		d();
	}

	static void d() {
		System.out.println(5/0);
	}	
}
