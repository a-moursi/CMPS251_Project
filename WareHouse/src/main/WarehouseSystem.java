package main;

import java.time.LocalDate;
import java.util.ArrayList;

import Data.RateTable;
import Discount.Discount;
import Products.Product;
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
		customers.add(c);
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public Customer findCustomerById(String id) {
		return null;
		
	}


	
	public void addProduct(Product p) {
		products.add(p);
	}

	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public Product findProductById(String id) {
		return null;
	}
	
	
	
	public void addDiscount(Discount discount) {
		
	}
	
	/**
	 * @return the discounts
	 */
	public ArrayList<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscountActive(Discount target, boolean active) {
		
	}
	
	
	
	private void deactivateOverlaps(Discount newcomer) {
			
	}
	
	
	
	public void addOrder(Order order) {
		
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	
	
	public void addShipment(Shipment shipment) {
		
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
