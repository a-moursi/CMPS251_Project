import Products.Product;

public class CartItem {
	private int quantity;
	private Product product;
	/**
	 * @param quantity
	 * @param product
	 */
	public CartItem(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
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
		return 0.0;
		
	}
	
	public double lineWeight() {
		return 0.0;
	}
	
	public String info() {
		return null;
	}
	
}
