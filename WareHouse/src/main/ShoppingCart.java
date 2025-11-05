package main;
import java.util.ArrayList;

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
		CartItem cartItemToAdd = new CartItem(product,quantity);
		boolean itemExists = false; // in the start I assumed that the item is not present in the cart
		for (CartItem cartItem : items) {
			if (cartItem.getProduct().equals(cartItemToAdd.getProduct())){  // item is present in the cart
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
		
	}
	
	public boolean isEmpty() {
		return true;
	}
	
	public void clear() {
		
	}
	public double subtotal() {
		return 0.0;
	}
	
	public double totalWeight() {
		return 0.0;
	}
	
	public void print() {
		
	}
	
	
	public ArrayList<OrderItem> toOrderItems(){
		return null;
	}
	
	
	
}
