package interfaces;

public interface Mother extends GrandMother{ // 무조건 동족 상속은 extends
	// interface 와 interface의 상속은 extends !!!
	String NAME = "한지민";
	
	void mother(); //추상메소드
	
}
