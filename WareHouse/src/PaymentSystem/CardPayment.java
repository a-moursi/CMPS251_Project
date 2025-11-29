package PaymentSystem;

import java.io.Serializable;

// Anas Ali Khan, 17/11/2025

public class CardPayment implements Payment,Serializable {
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
		
		return String.format("Card %s %.2f, (%s, %s)", this.currency, this.amount, this.cardHolder, this.maskedNumber);
	}

}
