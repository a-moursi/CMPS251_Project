package Products;

import java.util.ArrayList;

import main.App;

public class ProductListView {
	public static void printCategorized(ArrayList<Product> products) {// for now just prints all products
//		products.sort(null);// add the lambda method to compare the products where electronics come first
//							// then books then groceries
		for (Product p : products) {
			System.out.printf("%s: %s (ID:%s), stock: %d, price %s %.2f \n", p.getCategory().replace("Product", ""),
					p.getName(), p.getId(), p.getStock(), App.currency, p.getPrice());
		}
	}
}
