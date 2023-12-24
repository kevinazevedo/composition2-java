package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;	
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = scan.nextLine();
		System.out.print("Email: ");
		String email = scan.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(scan.next());	
		Client client = new Client(name, email, birthDate);		
				
		System.out.println("\nEnter order data:");
		System.out.print("Status: ");			
		OrderStatus status = OrderStatus.valueOf(scan.next());	
				
		Order order = new Order(new Date(), status, client);
		
		System.out.print("\nHow many items to this order? ");
		int n = scan.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Product name: ");
			scan.nextLine();
			String productName = scan.nextLine();
			System.out.print("Product price: ");
			Double productPrice = scan.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = scan.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderitem = new OrderItem(quantity, productPrice, product);
			
			order.addItem(orderitem);	
		}
			
		System.out.println(order);
		
		scan.close();
	}
}
