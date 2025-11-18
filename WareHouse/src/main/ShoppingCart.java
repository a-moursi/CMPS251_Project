package main;

import java.util.ArrayList;
import java.util.Scanner;

import Orders.OrderItem;
import Products.Product;

//Anas Ali Khan
//11/05/2025

public class ShoppingCart {
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
			if (cartItem.getProduct().getId().equals(cartItemToAdd.getProduct().getId())) { // item is present in the cart
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
		return items.isEmpty();
	}

	public void clear() {
		items.clear(); // This uses an instance method of ArrayList to clear the entire array
	}

	public double subtotal() {
		double subtotal = 0; // Initialize subtotal to 0
		for (CartItem item : items) { // loop through the items ArrayList
			subtotal += item.lineSubtotal(); // get the item price and add it subtotal
		}
		return subtotal;

	}

	public double totalWeight() {
		double totalWeight = 0; // Initialize totalWeight to 0
		for (CartItem item : items) { // loop through the items ArrayList
			totalWeight += item.lineWeight(); // get the item weight and add it totalWeight
		}
		return totalWeight;

	}

	public void print() {
		int i=0;
		for (CartItem item : items) { // loop through the items ArrayList
			System.out.printf("%d) Product: %s, Quantity: %d, Price: %.2f %s \n", i,  item.getProduct().getName(),
					item.getQuantity(), item.getProduct().getPrice(), App.currency); // Display contents of ArrayList items
			i++;
		}
		System.out.printf("Subtotal: %.2f %s", subtotal(), App.currency);
		

	}

	public ArrayList<OrderItem> toOrderItems() {
		ArrayList<OrderItem> orderItems = new ArrayList<>(); // Initialize an empty ArrayList orderItems
		for (CartItem item : items) { // loop through items
			OrderItem orderItemToAdd = new OrderItem(item.getProduct(), item.getQuantity(),
					item.getProduct().getPrice()); // create an instance of OrderItem from items
			orderItems.add(orderItemToAdd); // add to instance of OrderItem to the ArrayList
		}

		return orderItems;
	}

}
