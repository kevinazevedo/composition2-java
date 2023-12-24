package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
		
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;	
	private OrderStatus status;
	
	private Client client;
	
	List<OrderItem> orderitem = new ArrayList<>();
	
	public Order() {		
	}
		
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderitem;
	}
	
	public void addItem(OrderItem orderitem) {
		this.orderitem.add(orderitem);
	}
	
	public void removeItem(OrderItem orderitem) {
		this.orderitem.add(orderitem);
	}
	
	public double total() {
		double sum = 0.0;
		for (OrderItem item : orderitem) {
			sum += item.subTotal();
		}
		return sum;
	}
		
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n" + "ORDER SUMMARY:" + "\n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");		
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + " ("  + sdf2.format(client.getBirthDate())
				+ ") - " + client.getEmail() + "\n");	
		sb.append("Order items:" + "\n");
		
		double total = 0.0;	
		for (OrderItem o : orderitem) {
			sb.append(o.getProduct().getName() + ", $" + String.format("%.2f", o.getPrice())
			 		+ ", Quantity: " + o.getQuantity() 
			 		+ ", Subtotal: $" + String.format("%.2f", o.subTotal()) + "\n"); 					
			total += o.subTotal();			
		}
		sb.append("Total price: $" + String.format("%.2f", total));		
		return sb.toString();
	}		
	
}
