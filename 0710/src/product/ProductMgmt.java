package product;

public class ProductMgmt {
	public static void main(String[] args) throws java.io.IOException  {
		
		Product [] array = new Product[7];
		new ProductInput().input(array);
		new ProductCalc().calc(array);
		new ProductOutput().output(array);
		
	}
}