package com.employ.model;

public class EmployeeVO {
	private String empno; // 사원번호
	private String ename; // 사원이름
	private int overtime; // 야간시간
	private int family; // 가족수
	
	private String deptno; // 부서명
	private int sal; // 기본급
	private int sd_ho; // 호급수당
	private int sd_family;  // 가족수당
	private int sd_night;  // 야간수당
	
	
	private int totalPay;  // 총금액
 	private int realPay;  // 실수령액
	
	public EmployeeVO() {}


	
	
	
	public EmployeeVO(String empno, String ename, String deptno, int sal, int sd_ho, int sd_family, int sd_night,
			int totalPay, int realPay) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.sal = sal;
		this.sd_ho = sd_ho;
		this.sd_family = sd_family;
		this.sd_night = sd_night;
		this.totalPay = totalPay;
		this.realPay = realPay;
	}





	public EmployeeVO(String empno, String ename, int sal, int overtime, int family) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.overtime = overtime;
		this.family = family;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}



	public int getOvertime() {
		return overtime;
	}


	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}


	public int getFamily() {
		return family;
	}


	public void setFamily(int family) {
		this.family = family;
	}


	public String getDeptno() {
		return deptno;
	}


	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}


	public int getSal() {
		return sal;
	}


	public void setSal(int sal) {
		this.sal = sal;
	}


	public int getSd_ho() {
		return sd_ho;
	}


	public void setSd_ho(int sd_ho) {
		this.sd_ho = sd_ho;
	}


	public int getSd_family() {
		return sd_family;
	}


	public void setSd_family(int sd_family) {
		this.sd_family = sd_family;
	}


	public int getSd_night() {
		return sd_night;
	}


	public void setSd_night(int sd_night) {
		this.sd_night = sd_night;
	}


	public int getTotalPay() {
		return totalPay;
	}


	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}


	public int getRealPay() {
		return realPay;
	}


	public void setRealPay(int realPay) {
		this.realPay = realPay;
	}


}
