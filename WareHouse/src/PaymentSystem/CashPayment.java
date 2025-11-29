package PaymentSystem;
//Anas Ali Khan, 17/11/2025

import java.io.Serializable;

public class CashPayment implements Payment, Serializable {

	private String currency; // QAR
	private double amount;

	// ---------------------------------------
	public CashPayment(String currency, double amount) {
		super();
		this.currency = currency;
		this.amount = amount;
	}


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
		return String.format("Cash %s %.2f  ",this.currency,this.amount);	
	}

}
