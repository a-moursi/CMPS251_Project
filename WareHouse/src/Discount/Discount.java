package Discount;
import java.time.LocalDate;


public abstract class Discount {
	

	private String code;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean active;
	

	protected Discount(String code, LocalDate start, LocalDate end, boolean active) {
		super();
		this.code = code;
		startDate = start;
		endDate = end;
		this.active = active;
	}
	
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
	

	 public double calculateDiscount(double subtotal) {
		 
		 return 1;
	 }
	
	 
	 
	 public String getDetailsShort() {
		 
		 return "s";
	 }
 
	 
	 public String getDetails() {
		 
		 return "s";
	 }
	 
	 
	 protected String detailsTail() {
		 
		 return "s";
	 }
	 
	 
	 public static boolean overlaps(Discount a, Discount b) {
		 
		 
		 return true;
	 }
		 
	 
	 
	 	
}
