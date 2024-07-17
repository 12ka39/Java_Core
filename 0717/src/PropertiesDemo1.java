import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo1 {

	public static void main(String[] args) throws IOException {
		Properties info = new Properties(); // Creates an empty property list with no default values
		info.load(new FileInputStream(new File("productinfo.properties"))); // 파일 입력
		
		System.out.println("나이 = " + info.getProperty("age")); // 키를 주면 값이 넘어온다  12
		System.out.println("거주지 = " + info.getProperty("city")); // 키를 주면 값이 넘어온다 Seoul
	}

}
