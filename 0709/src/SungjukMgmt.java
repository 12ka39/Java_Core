// 이 코드 이해는 했는데 다시 보자
public class SungjukMgmt {

	public static void main(String[] args) {
		//정수 배열 사용할 거니까 전부 정수로. 교재에 나온 예제
		int [][] jumsus = {
				{67, 89, 100},
				{77, 99, 56},
				{100, 99, 88}
		};
	
		// 전체 학생의 총점 구하기 (이중 for문)
		for(int i=0; i<jumsus.length; i++) {
			// 헷갈렸는데, 이 코드가 한 번에 한 사람 것만 돌아가니까 총합, 평균, 학점이 하나씩 나타나는 거다.
			// 안 헷갈리면 이 주석 안 봐도 됨
			int tot=0;
			
			for(int j=0; j<jumsus[i].length; j++) tot += jumsus[i][j];  // 한줄이면 { } 생략 가능  67+89+100
			double avg = tot / 3.;
			char grade = (avg >= 90)? 'A' : // 삼항연산자 
									(avg >= 80)? 'B':
										(avg >= 70)? 'C':
											(avg >= 60)? 'D': 'F';
			
			//우선 한 행의 점수들 찍고
			for (int j=0; j<jumsus[i].length; j++)  System.out.printf("%5d\t", jumsus[i][j]);
			// 그 다음에 바로 옆에 tot, avg, grade 찍음 (%n 아니고 \t이니까 점수들 옆에 바로 붙는다)
			System.out.printf("%5d\t%10.1f%5c%n", tot, avg, grade);
			
		}
	}
}
