/*
 * 객체 비교 - 교재 p494
 	Override (재정의) 하지 않은 오리지날 equals()는 객제의 주소 비교를 한다.
 */
public class EqualsDemo {
	public static void main(String[] args) {
		Point original = new Point(30, 100);
		Point target = new Point(30, 100);
		// orginal == target; // 자바는 이런 코드 불가. 주소값 비교라서 어차피 결과하 항상 false임
		
		original.equals(target); // 기본적으로 Override하지 않는 오리지날 equals()는 객제의 주소 비교를 한다.
		System.out.println(original.equals(target)); // false (재정의 하기 전)
		//  true (재정의 후)
	}
}

class Point extends Object{
	private int x,y;

	public Point(int x, int y) { // 생성자
		this.x=x;  this.y=y;
	}

	////////////딱히 이 코드는 여기서 필요한 거 같진 않음/////////////////////
	@Override
	public String toString() {
		return String.format("(x,y) = (%d, %d)%n", this. x, this.y);
	} ///////////////////////////////////////////////////////////////////
	
	@Override // 재정의 - 객체의 주소 비교가 아니라 값비교를 해서 T/F 나올 수 있도록
	public boolean equals(Object obj) {
		Point p = (Point) obj;
		if(this.x == p.x && this.y == p.y) return true; // 
		else return false;
	}
}
