package Shipment;

import java.io.Serializable;

import main.Customer;

//Name: Salih Alhaj
//ID: 202405408
//Date: 21-11-2025

public class Shipment implements Serializable {

	private String orderId;
	private Customer customer;
	private Address address;
	private ShipmentStatus status;
	private double totalWeightKg;

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
		this.status  = ShipmentStatus.CREATED;
		this.address = address;
		this.totalWeightKg = totalWeightKg;
	}

	// For ( Checkout )
	public String basicInfo() {

		return String.format("Order ID: %s \nShipment: Order %s | %s | %s | %.2f kg to %s", orderId, orderId,
				customer.getName(), getStatus(), totalWeightKg, address.toSingleLine());

	}

	// For (Reports: [9] Shipments by Status)
	public String allShipments() {

		return String.format("Order %s | %s | %s | %.2f kg to %s", orderId, customer.getName(), getStatus(),
				totalWeightKg, address.toSingleLine());

	}

	// For (Reports: [10] Shipments not yet DELIVERED)
	public String notDelivered() {

		return String.format("%s | %s | %s | %.2f kg to %s", orderId, customer.getName(), getStatus(), totalWeightKg,
				address.toSingleLine());

	}

}
