
public class VariableDemo {
	/*
	static은 집 바깥에 있는 존재들이다. 집 안에 있지 않다.
	그래서 이 static 변수 가져다 쓰려면 어느 클래스 소속인지 반드시 밝혀줘야 한다.
	그리고 프로그램 실행되면 가장 먼저 메모리로 올라간다.
	
	static 변수는 공용되는 변수라 어느 클래스 소속인지를 밝혀야 한다.
	---> 그래서 static 변수를 클래스 변수하고 하는 거		
	VariableDemo.math, Demo.math 이런 식으로 앞에 클래스를 밝혀야 하기 때문에
	클래스 변수라고 한다 
	*/
	
	// 그래서 이 VariableDemo 클래스에서 갖고 있는 변수는
	// int eng 변수만 갖고 있는 거 (집 안에 있는)
		
	
	int eng = 100; // instance variable -> 객체 생성해야 사용할 수 있음
	static int math = 80; // class variable
		// math 변수는 자동으로 실행과 동시에 제일 먼저 메모리에 올라감
		// static이 붙어 있으니까 
	
	public static void main(String[] args) {
		int kor = 90; // local variable 지역변수
		int good;
		
		System.out.printf("ㅣㅏㅓㅣㅏㅓㅣㅓㅣㅏㅓ", math); // 80. 근데 클래스 안 써도 오류 안 나고 나오긴 한다.
			// 아마 가까운 걸 가져오는 듯?
		System.out.printf("수학 점수 = %d\n", VariableDemo.math); // 먼저 메모리에 올라가 있으니까 찍힌다
		System.out.printf("수학 점수 = %d\n", Demo.math); // 90
		System.out.printf("국어 점수 = %d\n", kor); // 50
		
		// eng 변수는 아직 못 찍는다
		// System.out.printf("영어 점수 = %d\n", eng); // 오류 non-static field 
		
		// good 변수 초기화 안 해줘서 오류
		// System.out.printf("굿 = %d\n", good); // 초기화 안 해줘서 오류
		
		
		VariableDemo vd = new VariableDemo();
		//new 땅을 산다. | 생성자가 그 땅에 건물을 짓는다 | vd가 집주소 저장
		//System.out.println("영어 점수 = %d\n", vd.eng); // 
		

		Demo d = new Demo();
		System.out.printf("영어 점수 = %d\n", d.eng); // 50
	}

}

class Demo {
	static int math = 70; // class variable
	int eng = 50; // 이거 찍으려면 Demo 집 만들고 해야 한다
}
