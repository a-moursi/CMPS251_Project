import Products.Product;

public class BookProduct extends Product{
	
	
	
	//---------------------------------------------
	
	public BookProduct(String id, String name, String currency, double price, double weightKg, int stockQty ) {
		super(id, name, currency, price, weightKg, stockQty);
	}
	
	//----------------------------------------------
	
	@Override
	public String getCategory() {
		return this.getClass().getSimpleName();
	}
	
	//---------------------------------------------
	
}
