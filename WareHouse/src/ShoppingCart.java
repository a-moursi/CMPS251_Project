import java.util.ArrayList;

import Products.Product;

public class ShoppingCart {
	private ArrayList<CartItem> items = new ArrayList<>();

	/**
	 * @return the items
	 */
	public ArrayList<CartItem> getItems() {
		return items;
	}

	public void addItem(Product product, int quantity) {
		
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
