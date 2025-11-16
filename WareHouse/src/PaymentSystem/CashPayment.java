package PaymentSystem;

public class CashPayment implements Payment {

	private String currency; // QAR
	private double amount;

	// ---------------------------------------

	public CashPayment(String currency, double amount) {
		
	}

	// ---------------------------------------------

	@Override
	public String currency() {
		return currency;
	}

	@Override
	public double amount() {
		return amount;
	}

	@Override
	public String summary() { 
		// TODO Auto-generated method stub
		return null;
	}

}
