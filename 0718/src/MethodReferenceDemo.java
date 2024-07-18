// <메소드 참조> 
// 람다 익스프레션의 메소드 구현부(바디)가 다른 클래스의 단 하나의 메소드를 사용한다는 걸 보장한다면
// 메소드 참조를 쓴다
// 클래스명::메소드명      메소드 파라미터는 안 써도 된다.  (잘 안 쓰지만, 혹시 누가 썼을 수 있음)

@FunctionalInterface
interface MyPolygon{
	double radianToDegree(double value);
}

public class MethodReferenceDemo {
	public static void main(String[] args) {
		//람다
		MyPolygon mp = (raian) -> Math.toDegrees(raian); // 반지름 들어오면 degree로 바꿔 리턴
		
		double result = mp.radianToDegree(1); 
		System.out.println(result); // 57.29577951308232
		
		
		// 메소드 참조
		MyPolygon mp1 = Math::toDegrees; // 단 하나의 메소드만 사용한다
		double result1 = mp1.radianToDegree(1);
		System.out.println(result1);
	}
}
