// AutoBoxing
public class WrapperDemo {

	public static void main(String[] args) {
		// 박싱 -> 언박싱
		// 1.5 버전은  복잡했는데 버전 업 하면서 더 간단해짐
		

		// BEFORE JDK 1.5
		int su = 5;
		Integer in = new Integer(su); // Wrapping, Boxing
		int another = in.intValue(); // Unwrapping, Unboxing
		
		
		// AFTER JDK 1.5  
		int su2 = 5;
		Integer in2 = su;   // AutoBoxing    -  new Integer(su) 가 생략된 코드
		int another2 = in2; //AutoUnboxing -  in.intValue() 가 생략된 코드
		System.out.println(another2); // 5
		
	}
}
