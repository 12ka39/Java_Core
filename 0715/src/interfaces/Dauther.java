package interfaces;

public interface Dauther extends Mother, Father{ // 인터페이스는 다중 상속이 가능하다
	
	void dauther(); // 추상 메소드라서 엄마, 아빠, 할머니의 메소드 구현하지 않아도 된다
}
