package main;
import Products.Product;

//Anas Ali Khan
//11/05/2025

public class OrderItem {
	private int quantity;
	private Product product;
	private double unitPriceQar;
	/**
	 * @param q
	 * @param p
	 * @param u
	 */
	public OrderItem(Product p, int q, double u) {
		super();
		this.quantity = q;
		this.product = p;
		this.unitPriceQar = u;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @return the unitPriceQar
	 */
	public double getUnitPriceQar() {
		return unitPriceQar;
	}
	
	public double lineTotal() {
		return this.quantity*this.unitPriceQar; // Calculates the line total
	}

	
	
}
