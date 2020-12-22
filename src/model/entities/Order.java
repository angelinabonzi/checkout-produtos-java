package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;		
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order(Date moment, Client client) {		
		this.moment = moment;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	// Calcula o total dos itens (valores já com o desconto caso tenha)
	public double total() {
		double sum = 0.0;
		for (OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}
	
	// Calcula o total geral dos itens
	public double totalGrand() {
		double sum = 0.0;
		for (OrderItem item : items) {
			sum += item.subTotalProduct();
		}
		return sum;
	}
	
	// Calcula o valor economizado, total geral - total com desconto
	public double saved() {			
		return totalGrand() - total();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");		
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Grand total: $");
		sb.append(String.format("%.2f", totalGrand()) + "\n");
		
		sb.append("Total payable: $");
		sb.append(String.format("%.2f", total()) + "\n");
		
		sb.append("Total saved: $");
		sb.append(String.format("%.2f", saved()) + "\n");
		
		return sb.toString();
	}
}
