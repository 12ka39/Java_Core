// 개발자의 시나리오에서 벗어나는 모든 게 예외
// -> 잘못된 값이 입력되거나 하는 게 모두 예외인데, 대비해야 한다
public class ExceptionDemo3_1 {


	public static void main(String[] args) /*throws HistoryException*/  {
		Student2 chulsu = new Student2();  chulsu.setKor(90);
		try {
			chulsu.setHistory(120);
		} catch (HistoryException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(chulsu); //chulsu.toString()
	}
}

/*
익셉션 던지는 거 throw 
메소드 선언부에 익셉션 유발 throws 
*/

class HistoryException extends Exception{ // Checked Exception  체크드 익셉션 -  내가 만든 익셉션

	public HistoryException(String msg) {
		super(msg);
	} 
	
}

class KoreanException extends RuntimeException{ //  Unchecked Exception  

	public KoreanException(String msg) { //   생성자
		super(msg);
	} 
	
}


class Student2{
	
	private int kor;
	private int history;
	public void setHistory(int history) throws HistoryException { //  Checked Exception은 반드시 throws를 해줘야 한다
		if(history >=0  &&  history<=100) this.history = history;
		if(history >= 0 && history <= 100) this.history = history;
		else throw new HistoryException("역사점수는 0부터 100점까지의 범위만 인정합니다.");
	}
	public void setKor(int kor) /*throws KoreanException*/ { // throws 3인칭 단수라 s -> 런타임 익셉션은 throws Exception  안 써도 됨
		if(kor >=0  &&  kor<=100) this.kor = kor;
		else throw new KoreanException("국어점수는 0부터 100점까지의 범위만 인정합니다");
	}
	
	@Override
	public String toString() {
		return "kor = " + this.kor + ", history = " + this.history;
	}
}
