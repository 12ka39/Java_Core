import java.util.Scanner;

public class ProductMgmt {

	public static void main(String[] args) {
		Product pencil = new Product();
		pencil.name = "모나미 연필";
		pencil.price = 1000;
		System.out.printf("name = %s, price =%,d%n", //%n 줄바꿈  \n 이라고 해도 됨
				// \n은 OS를 타기 때문에 %n을 사용하하는 게 좋다...
				pencil.name, pencil.price);
	
	
		Product computer = new Product();
		computer.name = "컴퓨터";
		computer.price = 20_000_00;
		System.out.printf("name = %s, price =%,d원%n",
				computer.name, computer.price);
	
	
		// 이걸 배열로 바꾸자 -> 배열은 다 참조 주소...
		
		
		Product [] array = new Product[2]; //Product 타입의 배열 틀만 만든거.
		Scanner sc = new Scanner(System.in);
		int i=0; //초기값;
		while(i<2) {
			array[i] = new Product(); //상품을 만들자. 객체 생성
			System.out.print("Name : "); array[i].name = sc.next();
			System.out.print("Price : ");  array[i].price = sc.nextInt();
			i++;
		}
		//출력
		for(i=0; i<2; i++) {
			System.out.printf("Name = %s, Price = %,d원%n",
					array[i].name, array[i].price);
		}
	
	}
}
