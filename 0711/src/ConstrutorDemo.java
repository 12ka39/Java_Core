// 생성자
/*
 new 연산자 = 힙메모리 공간확보 
생성자 = 객체의 필드를 초기화 
 */

// 생성자는 필드 초기화를 한다. 

import java.util.Scanner;

public class ConstrutorDemo {

	public static void main(String[] args) {
		Car sonata = new Car(); 
		System.out.println(sonata.getName()); // null
		System.out.println(sonata.getPrice()); // 0
		
		Product pen = new Product();
		
		Product pencil = new Product("모나미 연필", 1000, "모나미사"); 
			//매개변수 순서, 타입이 생성자에 만들어진 거랑 일치해야 한다.
		Product computer = new Product("노트북", 25_000_000, "LG Gram");
		Product tv = new Product("텔레비전", 30_000_000, "삼성전자");
		
		//API 문서에 기본 생성자는 숨겨져 있어서? 사용할 수 없다
		//Scanner sc = new Scanner();
	}

}
