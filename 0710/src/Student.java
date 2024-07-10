// 캡슐화 -> 변수는 데이터를 담고 있으므로, 모두 private로 한다

public class Student { // 네트워크만 있으면 누구든 접근할 수 있다. 옆 학교, 인공위성, 
	private String hakbun, name; // Field (변수라고 해도 되는데 보통 Field라고 한다) 
			     // 객체 지향 언어'론'에서는 속성(Attitude, Property, State) 라고 한다
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	private char grade; //A,B,C학점..
	
	// print 메소드 추가
	public void print() {
		System.out.printf("%-10s%5d%5d%5d%5d%7.1f%3c%n",
				hakbun, kor, eng, math, tot, avg, grade); 
	}
	
	
	
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	
	
	
	
	
}
