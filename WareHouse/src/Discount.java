import java.time.LocalDate;

public class Discount {
	//<<properties>>??
	private String code;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean active;
	
	//----------------------------------------------------
	
	public Discount(String code, LocalDate start, LocalDate end, boolean active) {
		super();
		this.setCode(code);
		this.setStartDate(start);
		this.setEndDate(end);
		this.setActive(active);
	}
	
	//----------------------------------------------

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	//---------------------------------------
	
	public double calculateDiscount(double subtotal) {
		double result = 0;
		
		return result;
	}
	
	public String getDetailsShort() {
		String result = null;
		
		return result;
	}
	
	public String getDetails() {
		String result = null;
		
		return result;
	}
	
	protected String detailsTail() {
		String tail = null;
		
		return tail;
	}
	
	//----------------
	
	public static boolean overlaps(Discount a, Discount b) {
		boolean overlap = false;
		
		return overlap;
	}
	
	
}
