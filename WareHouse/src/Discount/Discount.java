package Discount;

import java.time.LocalDate;

public abstract class Discount {

	private String code;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean active;
	// hi

	// ------------------------------------------------------------------------------------------

	protected Discount(String code, LocalDate start, LocalDate end, boolean active) {
		super();
		this.code = code;
		startDate = start;
		endDate = end;
		this.active = active;
	}

	// ------------------------------------------------------------------------------------------

	public String getCode() {
		return code;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean a) {
		active = a;
	}

	// ------------------------------------------------

	public abstract double calculateDiscount(double subtotal);

	// For ( Checkout )
	public abstract String getDetails();
	

	// For ( List/Toggle Discounts ) & (Reports: [1] All Discounts)
	public abstract String detailsTail();
	

	// For (Reports: [2] Active Discounts)
	public abstract String ActiveDiscounts();
	

	public static boolean overlaps(Discount a, Discount b) {

		if (a == null || b == null) return false;

		return a.startDate.isBefore(b.endDate) && a.endDate.isAfter(b.startDate);
	}

}
