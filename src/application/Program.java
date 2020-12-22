package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.entities.Promotion;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try { 
			System.out.println("Enter client data:");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.next();
			System.out.print("Birth date (DD/MM/YYYY): ");
			Date birthDate = sdf.parse(sc.next());
			
			Client client = new Client(name, email, birthDate);
							
			Order order = new Order(new Date(), client);
			
			System.out.println("Enter promotion data:");		
			System.out.print("Id: ");
			String id = sc.nextLine();
			sc.nextLine();
			System.out.print("Percentage: ");
			double percentage = sc.nextDouble();	
			Promotion promotion = new Promotion(id, percentage);
			
			System.out.print("How many items to this order? ");
			int n = sc.nextInt();
			for (int i=1; i<=n; i++) {
				System.out.println("Enter #" + i + " item data:");
				System.out.print("Product name: ");
				sc.nextLine();
				String productName = sc.nextLine();
				System.out.print("Product price: ");
				double productPrice = sc.nextDouble();

				Product product = new Product(productName, productPrice, promotion);

				System.out.print("Quantity: ");
				int quantity = sc.nextInt();

				OrderItem orderItem = new OrderItem(quantity, productPrice, product); 

				order.addItem(orderItem);
			}
			
			System.out.println();
			System.out.println("ORDER SUMMARY:");
			System.out.println(order);
		}
		
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}		
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
				
		sc.close();
	}

}
