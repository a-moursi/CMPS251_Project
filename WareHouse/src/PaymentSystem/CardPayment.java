package PaymentSystem;

// Anas Ali Khan, 17/11/2025

public class CardPayment implements Payment {
	private String currency;
	private double amount;

	private String cardHolder;
	private String maskedNumber;

	
	
	public CardPayment(String currency, double amount, String cardHolder, String maskedNumber) {
		super();
		this.currency = "QAR";
		this.amount = amount;
		this.cardHolder = cardHolder;
		this.maskedNumber = maskedNumber;
	}

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
		
		return String.format("Card payment: %s (%s), amount: %.2f  %s",this.cardHolder,this.maskedNumber ,this.amount, this.currency);
	}

}
