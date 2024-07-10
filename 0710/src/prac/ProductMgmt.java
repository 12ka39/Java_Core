package prac;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProductMgmt {

	public static void main(String[] args) throws IOException {
		
		//상품명   |    수량   |    판매단가  |    매입단가  |   운송료
		Scanner sc = new Scanner(new File("D:\\Workspace\\0710\\src\\prac\\productdata.txt"));
		
		Product [] array = new Product[7];
		
		for(int i=0; i<7; i++) {
			array[i] = new Product();
			String line = sc.nextLine();
			//System.out.println(line);
			String [] lineArray = line.split("\\s+");
			
			 array[i].setProduct(lineArray[0].trim());
			 array[i].setNumber(Integer.parseInt(lineArray[1].trim()));
			 array[i].setSell_price(Integer.parseInt(lineArray[2].trim()));
			 array[i].setBuy_price(Integer.parseInt(lineArray[3].trim()));  
			 
			 Methods md = new Methods();
			 md.profit(array[i]);
			
		}
		

	}

}
