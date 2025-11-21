package Orders;

import java.time.LocalDate;
import java.util.ArrayList;

import Discount.Discount;
import PaymentSystem.Payment;
import main.Customer;

// Anas Ali Khan
// 11/05/2025
public class Order {
	private String id;
	private LocalDate date = LocalDate.now();
	private double subtotal;
	private double discountAmount;
	private double shippingFee;
	private double total;
	private Customer customer;
	private ArrayList<OrderItem> items;
	private Discount appliedDiscount;
	private Payment payment;

	// Initializes the date to current date
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
	public Order(Customer customer, ArrayList<OrderItem> items, double subtotal,
			double discountAmount, double shippingFee, double total, Discount appliedDiscount, Payment payment) {

		this.id = OrderIdGenerator.nextId();
		this.customer = customer;
		this.date = LocalDate.now();
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
	public ArrayList<OrderItem> getItems() {
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
