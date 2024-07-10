// 커맨드 라인 명령
// cmd 창에서 입력

/*

D:\Workspace\0709\bin>java ArrayDemo1 Banana Orange Mango Apple

Banana
Orange
Mango
Apple

*/

public class ArrayDemo1 {

	public static void main(String[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
