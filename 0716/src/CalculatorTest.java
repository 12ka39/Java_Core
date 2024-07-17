import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;  // Unit 5는 jupiter라고 뜬다

class CalculatorTest {
	private Calculator cal;  // Test할 클래스
	
	@BeforeEach   //각 테스트를 검사하기 전에 할 일.  cal 객체를 만들어 준다
						//testAdd() 테스트 전에,   testSubtract() 테스트 전에 각각의 테스트 전에 시작한다
	
	void init() { // cal 객체를 만들어 준다
		this.cal = new Calculator(); 
	}
	
	
	@Disabled @ Test  // 테스트할 부분
	void test() {
		assertNotNull(cal); //null 이 아님을 주장한다 / 확고히 한다. 
	}
	
	
	
	@Test  // @Disabled 이건 검사헤서 빼달라는 뜻
	void testAdd() {
		assertEquals(8, this.cal.add(3, 5));  // 값이 일치함을 보장 - 
		//assertEquals(기댓값, 실제값)
	}

	@Test    
	void testSubtract() {
		assertEquals(5, this.cal.subtract(8, 3));
	}

	
	@Test
	void testMultiple() {
		assertEquals(24, this.cal.multiple(6, 4));
	}
	

	@Test
	void testDivide() {
		assertEquals(4.1, this.cal.divide(25, 6)); // 일부러 여기서 틀려보았다.
	}

}
