package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Input {
	private List<Product> list;
	private File file;
	private Scanner sc;
	
	public Input(List<Product> list) { // 생성자
		this.list = list;
		this.file = new File("./productdata.txt");
		
		try {
			this.sc = new Scanner(this.file);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다");
			System.exit(0); // 강제종료
		}
	}

	public void fileInput() {
		while (this.sc.hasNextLine()) { // 몇 개 있는지 모르니까 while로 돌리고, 라인으로 읽으니까..
			String line = this.sc.nextLine(); // 라인이 없을 때까지 계속 읽는다,
			//System.out.println(line);
		
			/*
			 1) String's split()
			 2) Scanner's useDelemeter()
			 3) String Tokenizer 
			 * */
			
			// StringTokenizer st = new StringTokenizer(line); // 자동으로 스페이스 기준으로 나눈다. 근데 문자열로 읽으니까 다른 걸로 하자
			Scanner scLine = new Scanner(line).useDelimiter("\\s+"); // 공백 기준으로 자를 거야
			Product p = new Product(scLine.next(), scLine.nextInt(), scLine.nextInt(), scLine.nextInt(), scLine.nextInt());
			//이게 생성자 호출하면서 값이 들어가는 거
			this.list.add(p); // 리스트에 제품 한 개 추가. 배열이 아니다. 컬렉션이다
			// stact -> push | map -> put
		}
	}

}
