

import java.util.Enumeration;
import java.util.Properties;

// property : 속성, 재산
//환경 변수 설정할 때 SystemPropertiesAdvanced 했었는데
// 그런 property 확인하는 방법이다.

//나중에 JDBC에서도 사용할 거다. properties
public class PropertiesDemo {
	public static void main(String[] args) {
		Properties infos = System.getProperties();  // System.getProperties()
		//	OS에게 OS가 갖고 있는 시스템 속성(재산)을 다 가져오라는 명령어
		
		Enumeration<Object> enums =   infos.keys(); // 거기서 키만 뽑는다
		while(enums.hasMoreElements()) {
			String key = (String) enums.nextElement();
			System.out.println(key + " => " + System.getProperty(key)); 
			//sun.cpu.isalist => amd64  이런 게 있음
		}
	}
}

/*
 * 
 --- 앞으로의 수업에 config가 중요하다 ------------

* properties                            key=value
* XML (spring MAVEN) 
* JSON                                     "key":value
*yaml(yml) (spring boot, spring, kebernetes)                key: value
 * */
