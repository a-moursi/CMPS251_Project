package Shipment;
import main.Customer;

public class Shipment {
	
	String orderId ;
	Customer customer; 
	Address address; 
	ShipmentStatus status; 
	double totalWeightKg;

	public ShipmentStatus getStatus() {
		return status;
	}

	public void setStatus(ShipmentStatus s) {
		status = s;
	}

	public Shipment(String orderId, Customer customer, Address address, double totalWeightKg) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.address = address;
		this.totalWeightKg = totalWeightKg;
	}
	
	public String basicInfo() {
		
		return String.format("Order %s | %s | %s | %.2f kg to %s", orderId, customer.getName(),getStatus(),totalWeightKg,address.toSingleLine());
		
		
	}
	
	
	
	
	
	
}
