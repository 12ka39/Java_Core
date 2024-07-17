// 에러 메시지 단계

/*
 * 1) e.getMessage()        - 오류 메시지 
 * 2) e                            - 오류 메시지와  Exception 타입
 * 3) e.printStackTrace()  - 가장 자세한 정보
 * 
 * */
// (try에서) 던진 Exception 과 (catch에서) 받는 Exception이 일치해야 한다
// multiple catch block 에서  catch 에는 순서가 있다.  ->> 오류들을  자식 먼저 쫙 쓰고 마지막에 부모 오류를 쓰자

public class ExceptionDemo1 {

	public static void main(String[] args) {
		Car matiz = new Car();
		matiz.name = "대우 마티즈";
		System.out.println(matiz.name);
		matiz = null; // 마티즈를 null로 만듦. 오류 발생시키려고
		
		try { // try가 오류를 던지고
			System.out.println(matiz.name);
		} catch(ArrayIndexOutOfBoundsException e) { //던전 오류를 catch가 받는다. 던져진 오류와 예외는 일치해야 한다
			// 유저에게는 간단한 메시지만 보여주면 된다
			System.out.println("아무 일 없었음~~");
			
		} catch(NegativeArraySizeException e) {
			System.out.println("배열의 크기는 음수이면 안 됩니다");
		} catch (RuntimeException e) { // 원래 NullPointerException 오류이지만 
			// NullPointerException의 부모인 RuntimeException 로 잡아도 된다
			
			System.out.println("여기서 잡았다");
			System.out.println(e.getMessage()); // 오류 메시지 : Cannot read field "name" because "matiz" is null
			
			System.out.println("-----------------------------------------------------");
			System.out.println(e); // 오류 메시지와  Exception 타입 : e.toString()으로 자동으로 바뀐다. 
			System.out.println("-----------------------------------------------------");
			e.printStackTrace(); // 제일 디테일한 오류 메시지를 보여준다
			
		}
		// 오류 나는데 try catch로 묶자
		/*
		 java.lang.NullPointerException: Cannot read field "name" because "matiz" is null
		at ExceptionDemo1.main(ExceptionDemo1.java:9)
		 * 
		 * */
	}

}
