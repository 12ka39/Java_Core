import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SungjukMgmt1 {

	public static void main(String[] args) throws IOException {
		// 이번에는 키보드 입력이 아니라  "파일" 로 학생 정보 읽겠다
		Scanner sc = new Scanner(new File("sungjuk.dat")); // 파일 만들거야. new File(파일명)-> 그리고 그 파일을 읽을 거야
		// 파일 위치(소스)에서 --------- 입력 버퍼까지 통로를 뚫는다. 
		// 잘 이해는 못했는데 OS가 뭔가를 한다고 했음. 그래서 java는 그 일을 안 해도 된다고 함
		Student [] stdArray = new Student[3]; // 앞으로 학생들의 정보가 저장될 [공간 확보]
		
		for(int i=0; i<3; i++) { // 학생 3명
			stdArray[i] = new Student(); // 비로소 여기서 [학생 생성]
			String line = sc.nextLine(); // "2024-001 가나다 100 80 70" 리턴타입 문자열
			//Parsing(필요한 정보만 잘라내기)
			//String을 이욯해서 자르자 - "2024-001"	"가나다"	"100" "80"  "70"
			// split 하면 String[] 로 반환한다
			String[] array = line.split("\\s+"); // \s+ 화이트 스페이스 하나 이상 있는 걸 잘라 
										// \ 정규식 기호라고 알려주는 거
			
			// trim()은 혹시 모를 양쪽 공백 제거
			stdArray[i].hakbun = array[0].trim(); // 학번... i번째 학생의 학번에 배열 0번째를 넣는다
			stdArray[i].name = array[1].trim(); // 이름
			stdArray[i].kor = Integer.parseInt(array[2].trim()); // 국어. 문자열로 들어왔으니까 parseInt
			stdArray[i].eng = Integer.parseInt(array[3].trim()); // 영어
			stdArray[i].math = Integer.parseInt(array[4].trim()); // 수학
			stdArray[i].grade ='A';
		}
		int j=0; // 초기화
		while( j<3) {
			System.out.printf("%10s\t%10s\t%5d\t%5d\t%5d\t%n",
					stdArray[j].hakbun, stdArray[j].name, 
					stdArray[j].kor, stdArray[j].eng, stdArray[j].math);
					j++;
		}
	}

}
