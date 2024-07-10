// return 과 반환형
public class MethodDemo3 {

	public static void main(String[] args) {
		MethodDemo3 md = new MethodDemo3();
		md.print(); // 메소드 호출 -> 11번 라인으로 가자
		md.print2();
		
	}
	
	double print() {
		int su = 5;
		System.out.println("Hello World");
		// return;  <-- 빈손으로 복귀
		return 0; // 반환타입이 double이니까 자동 형변환 (0.0이 된다)
		// System.out.println("Hello World"); Unreachable code <- return 이후 코드라 실행 불가
		// 메소드는 return 만나면 거기서 끝난다.
		
	} // 메소드가 끝나면 자기를 호출한 곳으로 돌아간다. 
	// 여기서는 6번 라인으로 돌아간다. 해외 갔다가 복귀하는 거
	// 복귀할 때 빈손으로 돌아가면 -> void    
	// 해외에서 복귀할 때 뭔가 들고가면 세관에 신고한다. 양주면 양주 샀다고 신고
	// 신고 제대로 안 하면 오류.
	
	String print2() {
		int su = 5;
		System.out.println("Hello");
		if(su %2 ==0) return "aaaa";
		else{
			System.out.println("world"); return "bbb";
		}
		
	} 
}
