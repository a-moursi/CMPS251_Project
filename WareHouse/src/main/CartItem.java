package main;

import Products.Product;

//Anas Ali Khan
//11/05/2025

public class CartItem {
	private int quantity;
	private Product product;

	/**
	 * @param quantity
	 * @param product
	 */
	public CartItem(Product p, int q) {
		super();
		this.product = p;
		this.quantity = q;

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
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double lineSubtotal() {
		return product.getPrice() * this.quantity; // computes the line total

	}

	public double lineWeight() {
		return product.getWeightKg() * this.quantity; // computes the line weight
	}

	public String info() {
		return null;
	}

}
