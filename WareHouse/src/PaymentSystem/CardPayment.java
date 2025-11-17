package PaymentSystem;

// Anas Ali Khan, 17/11/2025

public class CardPayment implements Payment {
	private String currency;
	private double amount;

	private String cardHolder;
	private String maskedNumber;


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
		
		return String.format("CardHolder name: %s, amount: %s: %.2f",this.cardHolder,this.currency,this.amount);
	}

}
