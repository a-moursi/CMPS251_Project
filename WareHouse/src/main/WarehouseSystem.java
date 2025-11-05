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

	public WarehouseSystem(LocalDate today) {
		super();
		this.today = today;
	}
	
	public LocalDate today() {
		return null;
	}


	public void addCustomer(Customer c) {
	
	}
	
	
	public Customer findCustomerById(String id) {
		return null;
		
	}


	
	public void addProduct(Product product) {
		
	}

	/**
	 * @return the products
	 */
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
	
	public void deactivateOverlaps(Discount newcomer) {
			
	}
	
	public void addOrder(Order order) {
		
	}
	
	/**
	 * @return the orders
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public void addShipment(Shipment shipment) {
		
	}
	
	

	/**
	 * @return the shipments
	 */
	public ArrayList<Shipment> getShipments() {
		return shipments;
	}

	/**
	 * @return the rateTable
	 */
	public RateTable getRateTable() {
		return rateTable;
	}

	public Discount findApplicableDiscount(LocalDate date) {
		return null;
	}





	
	
	
	
	
	
	
}
