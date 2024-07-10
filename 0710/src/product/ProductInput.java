package product;

public class ProductInput {
	public void input(Product[] array) throws java.io.IOException {
		
		java.util.Scanner sc = new java.util.Scanner(new java.io.File("productdata.txt"));
		
		for(int i = 0 ; i < array.length ; i++) {
			String line = sc.nextLine();
			String [] itemArray = line.split("\\s+");
			
			array[i] = new Product();
			array[i].setName(itemArray[0]);  //상품명
			array[i].setQuantity(Integer.parseInt(itemArray[1]));  //수량
			array[i].setSellPrice(Integer.parseInt(itemArray[2])); //판매단가
			array[i].setBuyPrice(Integer.parseInt(itemArray[3])); //매입단가
			array[i].setTransFee(Integer.parseInt(itemArray[4]));  //운송료
			
		}
	}
}