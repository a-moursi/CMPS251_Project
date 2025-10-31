import java.time.LocalDate;

public class Order {
	private String id;
	private LocalDate date;
	private double subtotal;
	private double discountAmount;
	private double shippingFee;
	private double total;
	private Customer customer;
	private OrderItem items;
	private Discount appliedDiscount;
	private Payment payment;
	/**
	 * @param id
	 * @param customer
	 * @param date
	 * @param items
	 * @param subtotal
	 * @param discountAmount
	 * @param shippingFee
	 * @param total
	 * @param appliedDiscount
	 * @param payment
	 */
	public Order(String id, Customer customer, LocalDate date, OrderItem items, double subtotal, double discountAmount,
			double shippingFee, double total, Discount appliedDiscount, Payment payment) {
		
		this.id = id;
		this.customer = customer;
		this.date = date;
		this.items = items;
		this.subtotal = subtotal;
		this.discountAmount = discountAmount;
		this.shippingFee = shippingFee;
		this.total = total;
		this.appliedDiscount = appliedDiscount;
		this.payment = payment;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * @return the items
	 */
	public OrderItem getItems() {
		return items;
	}
	
	/**
	 * @return the subtotal
	 */
	public double getSubtotal() {
		return subtotal;
	}
	
	/**
	 * @return the discountAmount
	 */
	public double getDiscountAmount() {
		return discountAmount;
	}
	/**
	 * @return the shippingFee
	 */
	public double getShippingFee() {
		return shippingFee;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @return the appliedDiscount
	 */
	public Discount getAppliedDiscount() {
		return appliedDiscount;
	}

	


	
}
