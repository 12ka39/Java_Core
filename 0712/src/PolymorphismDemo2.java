import java.util.Scanner;

public class PolymorphismDemo2 {
	public static void main(String[] args) {
		PolymorphismDemo2 pd = new PolymorphismDemo2();
		Poyuryu m = null;
		
		for (int i=0; i<5; i++) {
			int choice = pd.choose();
			switch(choice) {
				case 1: m = new Dog(); break; // 자식이 부모로 형변환, 근데 주소는 자식 주소로 같다
				case 2: m = new Cat();  break;
				case 3: m = new American(); break;
				case 4: m = new Korean();  break;
			}
			m.sayThing();
			
			// 부모m이 Dog를 가리켰다가, 고양이를 가리켰다가
		}
		
	}	
	
	int choose() { // 멤버 메소드 (객체 생성해야 사용할 수 있음)
		System.out.println("*************  Memu   ***********");
		
		System.out.println("1.Dog");
		System.out.println("2 Cat");
		System.out.println("3. American");
		System.out.println("4. Korean");

		Scanner sc = new Scanner(System.in);
		System.out.println("당신은 어느 종족입니까? (1~4) :");
		
		return sc.nextInt();
	}
}
