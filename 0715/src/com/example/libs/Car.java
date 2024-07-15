package com.example.libs;
//패키지
public class Car {
	public String name = "EF Sonata";
	protected int price = 30_000_000; // 부모자식일 경우만
	String color = "Gray"; // 자기 패키지 libs 안에서만 쓸 수 있음
		// 외부에서는 접근을 못 하기 때문에 많이 쓰인다
	private int commition = 10_000_000;
}
