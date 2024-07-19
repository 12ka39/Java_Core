
public class Hospital { // 환자
	private int num; // 번호
	private String code; // 진료코드
	private int day; // 입원일수
	private  int age; // 나이
	
	private String dept;
	private long jinchal;
	private long ibwon;
	private long jinryo;
	
	
	
	
	
	
	public Hospital(int num, String code, int day, int age) {
		super();
		this.num = num;
		this.code = code;
		this.day = day;
		this.age = age;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public long getJinchal() {
		return jinchal;
	}
	public void setJinchal(long jinchal) {
		this.jinchal = jinchal;
	}
	public long getIbwon() {
		return ibwon;
	}
	public void setIbwon(long ibwon) {
		this.ibwon = ibwon;
	}
	public long getJinryo() {
		return jinryo;
	}
	public void setJinryo(long jinryo) {
		this.jinryo = jinryo;
	}

	
	
	
}
