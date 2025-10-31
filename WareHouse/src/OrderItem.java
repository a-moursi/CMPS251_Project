
public class OrderItem {
	private int quantity;
	private Product product;
	private double unitPriceQar;
	/**
	 * @param quantity
	 * @param product
	 * @param unitPriceQar
	 */
	public OrderItem(Product p, int q, double u) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.unitPriceQar = unitPriceQar;
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
		return 0.0;
	}

	
	
}
