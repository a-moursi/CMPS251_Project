package main;

import java.time.LocalDate;
import java.util.ArrayList;

import Discount.Discount;
import Products.Product;
import Shipment.RateTable;
import Shipment.Shipment;

public class WarehouseSystem {
	private LocalDate today;
	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Discount> discounts = new ArrayList<>();
	private ArrayList<Order> orders = new ArrayList<>();
	private ArrayList<Shipment> shipments = new ArrayList<>();
	private RateTable rateTable = new RateTable();
	
	//------------------------------------------------------------------------------------------------

	public WarehouseSystem(LocalDate today) {
		super();
		this.today = today;
	}
	
	//------------------------------------------------------------------------------------------------
	
	public LocalDate today() {
		return null;
	}


	public void addCustomer(Customer c) {
		//validation first
		customers.add(c);
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public Customer findCustomerById(String id) {
		for(Customer c : customers) {
			if(c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}


	
	public void addProduct(Product p) {
		//validation first
		products.add(p);
	}

	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public Product findProductById(String id) {
		return null;
	}
	
	
	
	public void addDiscount(Discount discount) {
		//maybe i need to check before
		discounts.add(discount);
		//check if the new discount overlaps with any other discount
		this.deactivateOverlaps(discount); // deactivates discounts overlapping with the passed(new) discount
	}
	
	/**
	 * @return the discounts
	 */
	public ArrayList<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscountActive(Discount target, boolean active) {
		
	}
	
	
	
	private void deactivateOverlaps(Discount newcomer) { //deactivates active discounts that overlap with the passes discount
			
	}
	
	
	
	public void addOrder(Order order) {
		//maybe i need to check before
		orders.add(order);
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	
	
	public void addShipment(Shipment shipment) {
		//maybe i need to check before
		shipments.add(shipment);
	}
	
	public ArrayList<Shipment> getShipments() {
		return shipments;
	}

	
	
	public RateTable getRateTable() {
		return rateTable;
	}
	
	

	public Discount findApplicableDiscount(LocalDate date) {
		return null;
	}





	
	
	
	
	
	
	
}
