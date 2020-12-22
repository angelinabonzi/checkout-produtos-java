package model.entities;

public class Product {
	
	private String name;
	private Double price;
	
	private Promotion promotion;
	
	public Product(String name, Double price, Promotion promotion) {		
		this.name = name;
		this.price = price;
		this.promotion = promotion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
}
