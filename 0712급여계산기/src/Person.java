
public class Person {
	private int id, grade, ho, money, pay, tax, taxpay, sal, adj;
	// 사번, 급, 호, 수당, 지급액, 세금, 차인지급액, 급여, 조정액

	public Person(int id, int grade, int ho, int money, int pay, int tax, int taxpay, int sal, int adj) {
	
		this.id = id;
		this.grade = grade;
		this.ho = ho;
		this.money = money;
		this.pay = pay;
		this.tax = tax;
		this.taxpay = taxpay;
		this.sal = sal;
		this.adj = adj;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getHo() {
		return ho;
	}

	public void setHo(int ho) {
		this.ho = ho;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getTaxpay() {
		return taxpay;
	}

	public void setTaxpay(int taxpay) {
		this.taxpay = taxpay;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getAdj() {
		return adj;
	}

	public void setAdj(int adj) {
		this.adj = adj;
	}
	
}