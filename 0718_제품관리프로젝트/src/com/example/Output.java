package com.example;

import java.util.List;

public class Output {
	List<Product> list;
	
	public Output(List<Product> list) {  // 생성자
		this.list = list;
	}

	public void list() {
		this.labelPrint();
		
		for (Product p : this.list) {
			System.out.println(p); // p.toString()
		}
		
	}

	private void labelPrint() {
		System.out.println("                         << 제품 관리 프로그램>>");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("제품명\t\t수량\t판매단가\t매입단가\t운송료\t이익금\t\t이익율");
		System.out.println("----------------------------------------------------------------------");
	}
}
