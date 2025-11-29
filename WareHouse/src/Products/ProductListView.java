package Products;

import java.util.ArrayList;

import main.App;


public class ProductListView {
	public static void printCategorized(ArrayList<Product> products) {
		ArrayList<Product> sortedList = new ArrayList<>();


		for (Product p : products) {

			if (p instanceof ElectronicProduct) {
				sortedList.add(p);

			}
		}

		for (Product p : products) {

			if (p instanceof BookProduct) {
				sortedList.add(p);

			}
		}

		for (Product p : products) {

			if (p instanceof GroceryProduct) {
				sortedList.add(p);
			}
		}
		
		

		for (Product p : sortedList) {
			System.out.printf("%s: %s (ID %s), stock %d, price %s %.2f \n", p.getCategory().replace("Product", ""),
			p.getName(), p.getId(), p.getStock(), App.currency, p.getPrice());
		}
		
	}
}
