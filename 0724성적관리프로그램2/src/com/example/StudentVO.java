package com.example;

public class StudentVO extends Object {
	
	private String hakbun, name;
	private int kor, eng, mat, edp, tot; // edp는 전산과목
	private double avg;
	private char grade;
	
	
	
	
	/*
	@Override
	public String toString() { // API문서 - public String toString()
		
		return String.format("%-5s\\t%7s\\t%5d\\t%5d\\t%5d\\t%5d\\t%5d\\t%8.1f\\t%5c%n",
				this.hakbun, this.name, this.kor, this.eng, this.mat, this.edp,
				this.tot, this.avg, this.grade);
				
	}
	*/
	
	
	


	// 초기화할 때 (딱 입력 받을 때) 필요한 변수만 생성하자.
	// avg, tot,  grade는 나중에 메소드 돌려서 생기니까
	public StudentVO(String hakbun, String name, int kor, int eng, int mat, int edp) {
		super();
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.edp = edp;
	}


	// toString 재정의 -> 자동으로 코드 생성할 수 있다
	// 우클릭 -> source -> toString -> code style-> String.format
	@Override
	public String toString() {
		return String.format("Student [hakbun=%s, name=%s, kor=%s, eng=%s, mat=%s, edp=%s, tot=%s, avg=%s, grade=%s]",
				hakbun, name, kor, eng, mat, edp, tot, avg, grade);
	}


	// 게터, 세터 
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


	public int getMat() {
		return mat;
	}



	public void setMat(int mat) {
		this.mat = mat;
	}



	public int getEdp() {
		return edp;
	}



	public void setEdp(int edp) {
		this.edp = edp;
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
