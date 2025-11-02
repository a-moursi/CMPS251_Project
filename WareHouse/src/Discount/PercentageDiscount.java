package Discount;
import java.time.LocalDate;

public class PercentageDiscount extends Discount {
	
	
	private double percent;
	

	public PercentageDiscount(String code, LocalDate start, LocalDate end, boolean active, double percent) {
		super(code, start, end, active);
		this.percent = percent;
	}


	
	@Override
	public double calculateDiscount(double subtotal) {
		 
		 return (subtotal*percent)/100;
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
		
		return null;
	}
	

}
