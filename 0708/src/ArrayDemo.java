public class ArrayDemo {
	
	public static void main(String[] args) {
		//int [] age 배열은 참조형이라 8바이트
		// int age 는 int라 4바이트
		
		int [] age;  //declaration
		age = new int[4];   // creation (4바이트 x 4개)
			// 참조형이라 new 연산자를 이용해 메모리에 공간을 확보해야 한다.
		age[0] =6;  //assignment
		age[1] =7;
		age[2] =8;
		age[3] =9;
		
		
		//* 기본 타입의 배열
		char [] array = {'a', 'b', 'c', 'd'};//initialization
			// 이 방식은 무조건 선언과 할당을 한번에 해야 한다.
		
		//------> 이런 방식으로 하면 2줄로 할 수 있음.
		char [] array2 = null;
		array2 = new char [] {'a', 'b', 'c', 'd'};
		
		
		
		int [] array3;
		array3 = new int[4];
		array3[0] = 5;
		array3[1] = 6;
		array3[2] = 7;
		array3[3] = 8;
		for(int i=0; i<4; i++) {
			System.out.print("array[" + i + "]= " + array[i] + "\t");
				//array[0]= a  	array[1]= b	array[2]= c	array[3]= d	
		}
				
		
		
		// * 참조 타입의 배열 (주소의 주소. c로 얘기하자면 더블포인터)
		String [] array4 = {"Hello", "World", "Good", "Java", "A"};
			// array3은 String 배열 번지가 저장되는데, 그 칸 [0] 칸은
			//"Hello"가 저장되는 게 아니라,
			// String Hello의 참조주소(8바이트)가 저장된다.
			// array2[0] 은 8바이트.
		
			// 참조 배열 -> 주소배열
		
		
		System.out.println("");
		String [] array5 = {"Hello", "World", "Good", "Java", "A"};
		array5[3] = "Python";
		for (int i=0; i<5; i++) {
			System.out.println("array5["+i+"]= "+array5[i]);
		}
		
	}
}
