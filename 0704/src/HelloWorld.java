
public class HelloWorld {

	public static void main(String [] args){ // main함수. 애플리케이션을 시작하고 죵료한다. 
			// 애플리케이션 시작과 끝 = main함수. 지금 단일 스레드
			// 동작하기 때문에 메인 함수를 쓴다
			// 메인 함수는 외부에서 접근이 되어야 하므로 public
			// static 메인 함수는 HelloWorld 만들지 않아도 접근할 수 있다.
			// static은 공유하려고 쓰는거 ex)아파트의 놀이터, 디즈니랜드. 공용으로 사용하는 거 
		
			// 내가 예전에 공부했을 때 static은 프로그램 시작과 동시에 자동으로 실행된다고 기억했던 듯
			// void 값이 없다 (무치형)
		
			// java.lang은 import 필요 없음. Scanner 클래스는 java.util 소속이라 import 필요
			// System.in 시스템 입력  |  System.out 시스템 출력
		
			java.util.Scanner sc = new java.util.Scanner(System.in); 
				//System.in 시스템에서 입력할 거야 == 키보드 입력
				System.out.print("당신의 이름은? :");
				String name = sc.nextLine(); // 엔터치기 전까지 입력한, 한 줄을 읽어
				System.out.printf("귀하의 이름은 %s 입니다. \n", name);
				
				
				//객체의 참조(주소)가 끊어지면 가비지 콜렉터가 수집한다.
				// java에도 소멸자가 있음(제니퍼 소프트 회사) 가비지 콜렉터랑 다름 
	}
}

class A{}
class B{}
// 하나의 파일에는 public 클래스를 하나만 만들 수 있다.
// 다른 클래스는 public 붙이면 안 됨
// 근데 문제는 class A{}라고 하면 나중에 해당 클래스를 못 찾을 수 있다
// 이클립스에서는 한 파일에는 하나의 클래스만 만드는 걸 원칙으로 한다

