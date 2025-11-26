package main;

import java.util.ArrayList;
import java.util.Scanner;

import Products.Product;
import Products.ProductListView;

//Name: Abdelrahman Moursi
//ID: 202406103
//01-11-2025

public class CustomerMenu {

	public static void run(Scanner sc, WarehouseSystem sys) {

		String id = null;
		String name = null;
		// shows a menu for available customers
		System.out.println("Available Customer IDs: ");
		ArrayList<String> availableIds = new ArrayList<>();
		int i = 1;
		for (Customer c : sys.getCustomers()) {
			System.out.printf("%d- %s (%s)\n", i, c.getId(), c.getName());
			i++;
			availableIds.add(c.getId());
		}

		Customer currentC = null;
		do {
			System.out.print("\nEnter Customer ID to login: > ");
			id = sc.next();
			if (availableIds.contains(id)) {// if the id is available it finds the customer
				currentC = sys.findCustomerById(id);
				name = currentC.getName();
			} else {
				System.out.println("Choose customers from the list");
			}
		} while (!availableIds.contains(id));// loops if the id is not it in the list

		// MENU=========================================================================================
		final String CUSTOMERMENU = "\n--- Customer Menu (ID: " + id + "," + name + ") --\r\n"
				+ "1) List Products (by Category)\r\n" + "2) Add to Cart \r\n" + "3) Remove from Cart \r\n"
				+ "4) View Cart \r\n" + "5) Checkout \r\n" + "0) Logout \r\n\n" + "Choice > ";
		// =============================================================================================
		int choice;
		do {
			System.out.print(CUSTOMERMENU);
			choice = sc.nextInt();
			switch (choice) {
			case 1 -> ProductListView.printCategorized(sys.getProducts());// DONE
			case 2 -> {//checks if the quantity is available, and then subtract that qnty from
						// the stock, before adding item to cart
				System.out.print("Enter Product ID: > ");
				String pId = sc.next();
				System.out.print("Quantity: > ");
				int qnty = sc.nextInt();
				Product added = sys.findProductById(pId);
				if(added.getStock() >= qnty) {
					added.setStock(added.getStock()-qnty);// subtract from the available stock
					currentC.shoppingcart.addItem(sys.findProductById(pId), qnty);//add to cart 
				}else {
					System.out.println("Stock is not enough!");
				}
				
			} // DONE
			case 3 -> {//adds the qnty from the cart back to the stock, before removing the item
				currentC.shoppingcart.print();
				System.out.print("Enter index: > ");
				int index = sc.nextInt();
				CartItem removedItem = currentC.shoppingcart.getItems().get(index);
				Product removed = currentC.shoppingcart.getItems().get(index).getProduct();
				
				removed.setStock(removed.getStock()+removedItem.getQuantity());//adds the qnty back to stock
				currentC.shoppingcart.removeIndex(index);//remove from cart 
			}
			case 4 -> currentC.shoppingcart.print();// DONE
			case 5 -> {//checkout
				System.out.println("Customer menu Option 5(WIP)");
			}
			case 0 -> choice = 0;
			default -> System.out.println("Invalid choice!, try again (Customer Menu)");
			}
		} while (!(choice == 0));
	}

}
