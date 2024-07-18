package com.example;

import java.util.List;

public class Calc {
	private List<Product> list;
	
	public Calc(List<Product> list) { // 생성자
		this.list = list;
	}

	public void calc() {
		/*
		 4. 처리조건
		   1) 판매금액 = 수량 * 판매단가
		   2) 매입금액 = 수량 * 매입단가
		   3) 이익금 =판매금액 - (매입금액 + 운송료)
		   4) 이익율 = 이익금 / 매입금액 * 100 
		 */
		
		// 강화된 for는 배열과 컬렉션에서 사용할 수 있다
		for (Product p : list) {
			int sellMoney = p.getQuantity() * p.getSellPrice();
			int buyMoney = p.getQuantity() * p.getBuyPrice();
			int benefit = sellMoney - (buyMoney + p.getTransport());
			double rate = (double) benefit / buyMoney * 100;
			
			p.setBenefit(benefit);
			p.setRate(rate);
					
		}
	}

}
