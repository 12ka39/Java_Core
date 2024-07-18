package com.example;

// 입출력 기준으로 필드를 만들면 된다

public class Product{
	// public class Product implements Coparable<Product> 이렇게 하면 product가 sorting을 할 수 있게 됨
	private String name;
	private int quantity;
	private int sellPrice;
	private int buyPrice; 
	private int transport; // 운송료
	private int benefit; // 이익금
	private double rate; // 이익율
	
	
	
	
	
	
	@Override
	public String toString() {
		return String.format(
				"%10s\t%,7d\t%,7d\t%,7d\t%,7d\t%,10d\t%7.2f", name,
				quantity, sellPrice, buyPrice, transport, benefit, rate);
	}


	public Product(String name, int quantity, int sellPrice, int buyPrice, int transport) { // 생성자
		this.name = name;
		this.quantity = quantity;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.transport = transport;
	}

	
	// 이 프로그램에서 생성자로 값이 세팅된 변수들은 setter가 필요 없다.
	// 만들 때 getter만 만들어 주자
	// 다 만들어줘도 상관은 없음

	public int getBenefit() {
		return benefit;
	}

	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}


	public int getSellPrice() {
		return sellPrice;
	}


	public int getBuyPrice() {
		return buyPrice;
	}


	public int getTransport() {
		return transport;
	}
}
