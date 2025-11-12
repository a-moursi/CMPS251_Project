package PaymentSystem;

public class CashPayment implements Payment {

	private String currency; // QAR
	private double amount;

	// ---------------------------------------

	public CashPayment(String currency, double amount) {
		// idk
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
	public String summary() { // idk
		// TODO Auto-generated method stub
		return null;
	}

	// -------------------------------------------

	// the methods have something to do with the interface thing
	// we didnt cover it yet so leave it for later

	// ---------------------------------
}
