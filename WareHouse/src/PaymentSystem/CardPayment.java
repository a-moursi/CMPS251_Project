package PaymentSystem;

public class CardPayment implements Payment {
	private String currency;
	private double amount;

	private String cardHolder;
	private String maskedNumber;

	// --------------------------------------------------

	public CardPayment(String currency, double amount, String cardHolder, String maskedNumber) {
		
	}

	// --------------------------------------------

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
