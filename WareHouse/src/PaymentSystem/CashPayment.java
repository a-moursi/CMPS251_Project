package PaymentSystem;
//Anas Ali Khan, 17/11/2025

public class CashPayment implements Payment {

	private String currency; // QAR
	private double amount;

	// ---------------------------------------



	// ---------------------------------------------

	@Override
	public String currency() {
		return "QAR";
	}

	@Override
	public double amount() {
		return amount;
	}

	@Override
	public String summary() { 
		// TODO Auto-generated method stub
		return String.format("Amount paid:  %s: %s", this.currency,this.amount);
		
	}

}
