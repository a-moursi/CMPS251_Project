
public class CardPayment implements Payment{
	private String currency;
	private double amount;
	
	private String cardHolder;  
	private String maskedNumber; 
	
	//--------------------------------------------------
	
	public CardPayment(String currency, double amount, String cardHolder, String maskedNumber) {
		//idk
	}
	
	//--------------------------------------------

	@Override
	public String currency() {
		return currency;
	}

	@Override
	public double amount() {
		return amount;
	}

	@Override
	public String summary() {//idk
		// TODO Auto-generated method stub
		return null;
	}
	
	//the methods have something to do with the interface thing
	//we didnt cover it yet so leave it for later
	
}
