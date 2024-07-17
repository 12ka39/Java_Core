
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class IODemo {

	public static void main(String[] args) {
		System.out.print("영어 글자 한 개를 입력하세요. :");
		InputStream is = System.in; // Scanner가 아니라 InputStream으로 키보드 입력 받았다.
		/*
		  InputStream은 데이터를 읽을 때, 사용할 수 있는 클래스라고 생각하시면 되고,
		  OutputStream은 데이터를 출력할 때, 사용할 수 있는 클래스라고 생각하시면 됩니다.
		 */
		/*
		 *<Scanner 클래스와 InputStream 클래스 차이>
		 * 입력을 받는 클래스는 자바에서 기본제공하는 가장 기본적인 클래스가 InputStream입니다.
			이 클래스는 입력에 관련한 기본적인 기능위주라 정수형으로 자료를 받는다던가 라인단위로 입력을
			받는기능이 없기 때문에 이런 기능들을 추가해서 좀더 편하게 입력받을수 있는 메소드를 제공하는것이
			Scanner 클래스입니다.
			Scanner가 InputStream을 확장해서 편한 기능을 추가한 클래스라고 생각하시면 됩니다.
		 */
		int code = 0;
		
		try {
			code = is.read(); // read() Reads the next byte of data from the input stream.
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("code = " + code); // A 입력시 65 나온다 - 아스키 코드
		System.out.println("code = " + (char) code); // A 입력시 A 나온다
		// 한글은 2바이트라 잘 못 읽는다. 이상하게 나온다
	} 

}
