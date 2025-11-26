package Products;

//Name: Abdelrahman Moursi
//ID: 202406103
//Date: 01-11-2025

public class ElectronicProduct extends Product {

	// -------------------------------------

	public ElectronicProduct(String id, String name, double price, double weightKg, int stockQty) {
		super(id, name, price, weightKg, stockQty);
	}

	// ---------------------------------------

	@Override
	public String getCategory() {
		return this.getClass().getSimpleName();
	}

	// -----------------------------

}
