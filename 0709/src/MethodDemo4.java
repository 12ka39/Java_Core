
// return된 값이 있을 경우, 호출한 곳에서 받아줘야 한다.
// 받아줄 상자가 없으면 그냥 사라짐.

public class MethodDemo4 {
	public static void main(String[] args) {
		MethodDemo4  md = new MethodDemo4();
		int result = md.calcHap(3, 27); // 코드 21번라인 return hap을 받아줄 변수가 필요하다. int result가 받아줌
		System.out.println(result);
		
		result = md.calcHap(1, 50);
		System.out.println(result);
		
		result = md.calcHap(50, 70);
		System.out.println(result);
	}
	
	
	int calcHap(int start, int end) { 
		int hap = 0;
		for(int i=start; i<=end; i++) {
			hap +=i;
		}
		return hap; // 반환값.
	}
}
