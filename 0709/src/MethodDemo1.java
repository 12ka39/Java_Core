/*
 * Method를 호출하는 방법 3가지
 * 1) Call(Pass) by Name ----------> calcHap() 이름으로 호출
 * 2) Call(Pass) by Value ----------> md.calcHap(3, 27)  매개 변수
 * 3) Call(Pass) by Referance
 * 
 * */

//메소드 호출   (2) Call(Pass) by Value
public class MethodDemo1 {
	public static void main(String[] args) {
		MethodDemo1  md = new MethodDemo1();
		md.calcHap(3, 27);
		md.calcHap(1, 50);
		md.calcHap(50, 70);
	}
	
	void calcHap(int start, int end) { 
		int hap = 0;
		for(int i=start; i<=end; i++) {
			hap +=i;
		}
		System.out.println(start + "부터" + end + "까지의 합은 " + hap + "입니다");
	}
	
}