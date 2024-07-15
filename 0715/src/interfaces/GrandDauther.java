package interfaces;


//인터페이스는 a. 형용사형으로 사용한다. ~able


//인터페이스 할머니 - 아빠, 엄마 - 딸의 모든 메소드를 다 상속하게 된다 (빚이 상속된다)
// 다중 상속 하면 복잡해짐. 가능하면 피하는 게 좋다,
public class GrandDauther implements Dauther {
	
	public static void main(String[] args) {
		GrandMother gm = new GrandDauther(); gm.grandMother(); // 부모 메소드에 따라 접근할 수 있는 메소드가 다르다
		// GrandMother는 본인의 메소드만 접근 가능
		
		Mother mother = new GrandDauther(); mother.mother(); 
		// Mother는 본인과  GrandMother 메소드 접근 가능
		
		Father father = new GrandDauther(); father.father(); 
		// Father는 본인 메소드만 접근 가능
		
		Dauther sara = new  GrandDauther(); sara.dauther();
		// 딸은 할머니, 아빠, 엄마, 그리고 본인 메소드 모두 접근 가능
		
		Dauther [] array = new Dauther[3];
		// array[0] = new GrandDauther(); 
		System.out.println(Mother.NAME + "," + Father.NAME); // 상수는 인터페이스 이름으로 접근한다
				
	}
	

	@Override
	public void mother() { System.out.println("Called by mother()"); }

	@Override
	public void grandMother() { System.out.println("Called by grandmother()"); }

	@Override
	public void father() { System.out.println("Called by father()"); }

	@Override
	public void dauther() { System.out.println("Called by dauther()"); }

}
