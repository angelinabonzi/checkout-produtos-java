package model.entities;

public class OrderItem {
	
	private Integer quantity;
	private Double price;
	
	private Product product;
	
	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	//Calcula o desconto do item
	public double discount() {		
		return (price * product.getPromotion().getAmount() * quantity);	
	};
	
	//Calcula o subtotal do item, de acordo com o desconto caso tenha
	public double subTotal() {
				
		double total = 0.0;
		
		if (discount() != 0.0) {					
			total = (price * quantity) - discount();
		} 
		else {					
			total = price * quantity;
		}
		
		return total;
	}
	
	//Calcula o subtotal do item sem o desconto
	public double subTotalProduct() {			
		return price * quantity;
	}
	
	@Override
	public String toString() {
		return product.getName() 
				+ ", $" 
				+ String.format("%.2f", price) 
				+ ", Quantity: " 
				+ quantity 
				+ ", Discount: "
				+ String.format("%.2f", discount()) 
				+ ", Subtotal: $" 
				+ String.format("%.2f", subTotal());
	}

}
