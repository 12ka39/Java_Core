package product;

public class Product {
	
	private String name;
	private int quantity, buyPrice, sellPrice;
	private int transFee, benefit;
	private double benefitRate;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	public int getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	public int getTransFee() {
		return transFee;
	}
	public void setTransFee(int transFee) {
		this.transFee = transFee;
	}
	public int getBenefit() {
		return benefit;
	}
	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}
	public double getBenefitRate() {
		return benefitRate;
	}
	public void setBenefitRate(double benefitRate) {
		this.benefitRate = benefitRate;
	}


}