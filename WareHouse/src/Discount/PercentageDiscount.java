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
		 
		 return (subtotal*percent)/100.0;
	 }
	

	@Override
	 public String getDetails() {
		 
		 return String.format("Discount (Percent(%s) %.2f% [%s to %s]):",getCode()
				 ,percent,getStartDate(),getEndDate());
	 }


	@Override
	public String detailsTail() {
		
		 return String.format("Percent(%s) %.2f%% [%s to %s] | Active: %b",getCode()
				 ,percent,getStartDate(),getEndDate(),isActive());
	}



	@Override
	public String ActiveDiscounts() {
		
		return String.format("Percent(%s) %.2f%% [%s to %s]",getCode()
				 ,percent,getStartDate(),getEndDate());
	}
	
	

}
