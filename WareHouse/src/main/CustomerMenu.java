package main;

import java.util.Scanner;

//Name: Abdelrahman Moursi
//ID: 202406103
//01-11-2025

public class CustomerMenu {

	public static void run(Scanner sc, WarehouseSystem sys) {

		String id = null;
		String name = null;
		final String CUSTOMERMENU = "\n--- Customer Menu (ID: " + id + "," + name + ") --\r\n"// shows the ID and Name
																								// of the customer
																								// chosen the previous
																								// menu
				+ "1) List Products (by Category)\r\n" + "2) Add to Cart \r\n" + "3) Remove from Cart \r\n"
				+ "4) View Cart \r\n" + "5) Checkout \r\n" + "0) Logout \r\n\n" + "Choice > ";

		// shows a menu for available customers
		System.out.println("Available Customer IDs: ");
		int i = 1;
		for (Customer c : sys.getCustomers()) {
			System.out.printf("%d- %d (%s)\n", i, c.getId(), c.getName());
			i++;
		}

		// choose the customer
		System.out.println("Enter Customer ID to login: > ");
		id = sc.next();

		// should validate if the input is valid/in the list before continuing
		Customer current = sys.findCustomerById(id);
		name = current.getName();

		int choice;
		do {
			System.out.print(CUSTOMERMENU);
			choice = sc.nextInt();// do try catch for invalid input
			switch (choice) {
			case 1 -> System.out.println("Customer menu Option 1(WIP)");
			case 2 -> System.out.println("Customer menu Option 2 (WIP)");
			case 0 -> choice = 0;// dont like it but idk
			default -> System.out.println("Invalid choice!, try again (Customer Menu)");
			}
		} while (!(choice == 0));
	}

}
