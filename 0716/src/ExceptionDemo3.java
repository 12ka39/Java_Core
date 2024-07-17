// 문법상의 오류는 없지만, 로직상의 오류가 있을 때 예외 처리
//------------------이거 좀 이상함
public class ExceptionDemo3 {

	public static void main(String[] args) {
		Student chulsu = new Student(); 
		
		try {
			chulsu.setKor(120); // 오류가 발생하면 바로 catch로 넘어가서 10라인 실행 안 하고 13라인으로 넘어간다 (return 같은 거)
			System.out.println(chulsu); // chulsu.toString()
			
		} catch(RuntimeException e) { // 요즘은 거의 컴파일 단계에서 오류 검사한다
			System.out.println(e.getMessage());
		}
	}
}

/*
익셉션 던지는 거 throw 
메소드 선언부에 익셉션 유발 throws 
*/
class KoreanException extends RuntimeException{ //  내가 만드는 익셉션

	public KoreanException(String msg) { //   생성자
		super(msg);
	} 
}

class Student{
	private int kor;
	
	public void setKor(int Kor) throws Exception { // throws 3인칭 단수라 s
		if(kor >=0  &&  kor<=100) this.kor = kor;
		//else throw new KoreanException("국어점수는 0부터 100점까지의 범위만 인정합니다");
		else throw new RuntimeException("국어점수는 0부터 100점까지의 범위만 인정합니다");
	}
	
	@Override
	public String toString() {
		return "kor = " + this.kor;
	}
	
	
	
}