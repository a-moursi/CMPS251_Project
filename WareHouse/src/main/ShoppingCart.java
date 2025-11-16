package main;

import java.util.ArrayList;
import java.util.Scanner;

import Orders.OrderItem;
import Products.Product;

//Anas Ali Khan
//11/05/2025

public class ShoppingCart {
	Scanner input = new Scanner(System.in);
	private ArrayList<CartItem> items = new ArrayList<>();

	/**
	 * @return the items
	 */
	public ArrayList<CartItem> getItems() {
		return items;
	}

	public void addItem(Product product, int quantity) {
		CartItem cartItemToAdd = new CartItem(product, quantity);
		boolean itemExists = false; // in the start I assumed that the item is not present in the cart
		for (CartItem cartItem : items) {
			if (cartItem.getProduct().equals(cartItemToAdd.getProduct())) { // item is present in the cart
				cartItem.setQuantity(cartItem.getQuantity() + quantity); // quantity is updated
				itemExists = true; // item is already present in the cart so the flag is set to true
				break; // loop exists after finding a match, no need for unnecessary iterations
			}
		}
		if (!itemExists) { // item is not present
			items.add(cartItemToAdd); // item is just normally added
		}

	}

	public void removeIndex(int index) {
		items.remove(index); // This uses an instance method of ArrayList to remove the element
	}

	public boolean isEmpty() {
		if (items.size() == 0) { // checks that size of array list is zero
			return true;
		}
		return false;
	}

	public void clear() {
		items.clear(); // This uses an instance method of ArrayList to clear the entire array
	}

	public double subtotal() {
		return 0.0;
	}

	public double totalWeight() {
		return 0.0;
	}

	public void print() {

	}

	public ArrayList<OrderItem> toOrderItems() {
		return null;
	}
	// This works
}
