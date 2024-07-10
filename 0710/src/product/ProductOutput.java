package product;

public class ProductOutput {
	public void output(Product[] array) {
		
		System.out.println("                              <<상품별 판매 이익금 및 이익률표>>");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("상품명\t\t\t수량\t판매단가\t매입단가\t운송료\t\t이익금\t\t\t이익률");
		System.out.println("----------------------------------------------------------------------------------------------");
		
		for(Product p : array) {
			System.out.printf("%-20s%,d\t%,d\t%,d\t%,d\t\t%,d\t%10.2f%n", 
					p.getName(), p.getQuantity(), p.getSellPrice(), p.getBuyPrice(),
					p.getTransFee(), 	p.getBenefit(), p.getBenefitRate());
			
		}
	}
}