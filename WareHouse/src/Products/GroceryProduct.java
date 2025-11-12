package Products;

//Name: Abdelrahman Moursi
//ID: 202406103
//Date: 01-11-2025

public class GroceryProduct extends Product {

	// ---------------------------------------------

	public GroceryProduct(String id, String name, String currency, double price, double weightKg, int stockQty) {
		super(id, name, currency, price, weightKg, stockQty);
	}

	// ----------------------------------------------

	@Override
	public String getCategory() {
		return this.getClass().getSimpleName();
	}

	// ---------------------------------------------
}
