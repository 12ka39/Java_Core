package prac;

public class Product {
	//상품명            수량         판매단가         매입단가         운송료        이익금         이익율
	private String product;
	private int number;
	private int sell_price;
	private int buy_price;
	private int unsong;
	private int profit;
	private int profit_rate;
	
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getSell_price() {
		return sell_price;
	}
	public void setSell_price(int sell_price) {
		this.sell_price = sell_price;
	}
	public int getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(int buy_price) {
		this.buy_price = buy_price;
	}
	public int getUnsong() {
		return unsong;
	}
	public void setUnsong(int unsong) {
		this.unsong = unsong;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public int getProfit_rate() {
		return profit_rate;
	}
	public void setProfit_rate(int profit_rate) {
		this.profit_rate = profit_rate;
	}
	
	
	
	
}
