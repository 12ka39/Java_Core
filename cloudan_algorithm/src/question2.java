//https://school.programmers.co.kr/learn/courses/30/lessons/120838

/*
머쓱이는 친구에게 모스부호를 이용한 편지를 받았습니다. 
그냥은 읽을 수 없어 이를 해독하는 프로그램을 만들려고 합니다. 
문자열 letter가 매개변수로 주어질 때, 
letter를 영어 소문자로 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
모스부호는 다음과 같습니다.

a ~ z에 해당하는 모스부호가 순서대로 담긴 배열입니다.
{".-","-...","-.-.","-..",".","..-.","--.","....","..",
".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}

소문자 a : 아스키코드 97

morse = { 
    '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
    '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
    '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
    '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
    '-.--':'y','--..':'z'
}

*/

import java.util.Scanner;
//미완성 코드입니다
public class question2 {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("모스부호를 입력하세요");
		String letter = scan.next();
		morse(letter);
	}
	
	public static String morse(String letter) {
		String [] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
				".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

		String[] letters = letter.split("\\s+");
		String answer=null;
		char ans = 0;

		for (String ch : letters) {
			for(int i=0; i>morseCodes.length; i++) {
				if(ch.equals(morseCodes[i])) {
					ans = (char)(97 + i);
				}
			}
			answer += ans;
			System.out.println(answer); // null
		}
		return answer;
		}
	}
