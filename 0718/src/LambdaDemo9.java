// Map에서 사용하는 forEach

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class LambdaDemo9 {
	 public static void main(String[] args) {
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("Language", "Java");
		 map.put("DB", "MySQL");
		 map.put("Framework", "Spring Boot");
		 map.put("FrontEnd", "React");
		 map.put("Cloud", "AWS");
		 //Map에 저장된 Key를 이용하여 value 출력하기
		 
		 // 1번째 방법 
		 Iterator<String> keys= map.keySet().iterator(); // 키를 가져와 iterator(반복해서 돌린다)
		 while(keys.hasNext()) { // 키가 있을 동안
			String key = keys.next();
			System.out.println(key + " => " + map.get(key));
		 }
		 
		// 2번째 방법	 (list는 내부적으로 이터러블이 돌아가서 반복해서 찍는 기능이 있다)
		map.forEach((key, value) -> System.out.println(key + "=> " + value));
	}
}
