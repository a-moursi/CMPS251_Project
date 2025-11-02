package Discount;
import java.time.LocalDate;

public class FixedAmountDiscount extends Discount {
	
	private double amountQar;
	

	public FixedAmountDiscount(String code, LocalDate start, LocalDate end, boolean active, double amountQar) {
		super(code, start, end, active);
		this.amountQar = amountQar;
		
	}

	
	
	@Override
	public double calculateDiscount(double subtotal) {
		 
		 return amountQar;
	 }
	
	@Override
	public String getDetailsShort() {
		 
		 return "s";
	 }

	 
	@Override
	 public String getDetails() {
		 
		 return "s";
	 }
	

	@Override
	protected String detailsTail() {
		 
		 return "s";
	 }
	
	
	private String activeString() {
		
		
		return "s";
	}

}
