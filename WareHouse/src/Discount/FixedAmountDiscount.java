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
	 public String getDetails() {
		 
		return String.format("Discount (Fixed(%s) QAR %.2f [%s to %s]):",getCode()
				 ,amountQar,getStartDate(),getEndDate());
	 }


	
	@Override
	protected String detailsTail() {
		
		return String.format("Fixed(%s) QAR %.2f [%s to %s] | Active: %b",getCode()
				 ,amountQar,getStartDate(),getEndDate(),isActive());
	}



	@Override
	public String ActiveDiscounts() {
		
		return String.format("Fixed(%s) QAR %.2f [%s to %s]",getCode()
				 ,amountQar,getStartDate(),getEndDate());
	}
	
}
