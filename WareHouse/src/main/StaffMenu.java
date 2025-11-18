package main;

import java.time.LocalDate;
import java.util.Scanner;

import Discount.*;
import Products.*;
import Shipment.*;

//Name: Abdelrahman Moursi
//ID: 202406103
//Date: 01-11-2025

public class StaffMenu {

	public static void run(Scanner sc, WarehouseSystem sys) {//DONE

		final String STAFFMENU = "\n--- Staff Menu --\r\n" + "1) Add Customer (ID + Name) \r\n"
				+ "2) List/Toggle Discounts \r\n" + "3) Create Discount\r\n" + "4) Add Product \r\n"
				+ "5) Update Shipment Status \r\n" + "6) Reports (~15)\r\n" + "0) Back \r\n\n" + "Choice > ";
		// ----------

		int choice;
		do {
			System.out.print(STAFFMENU);
			choice = sc.nextInt();// do try catch for invalid input

			switch (choice) {
			case 1 -> addCustomer(sc, sys);
			case 2 -> listToggleDiscounts(sc, sys);
			case 3 -> createDiscount(sc, sys);
			case 4 -> addProduct(sc, sys);
			case 5 -> updateShipment(sc, sys);
			case 6 -> System.out.println("Option 6 not implemented yet");// Reports
			case 0 -> choice = 0;
			default -> System.out.println("Invalid choice!, try again(Staff Menu)/n");
			}
		} while (!(choice == 0));
	}

	private static void addCustomer(Scanner sc, WarehouseSystem sys) {//DONE
		// get customer info and make a new customer and pass it (id and name)
		System.out.print("Customer ID: > ");
		String id = sc.next();
		// check if the id is valid and that it doesn't already exist
		System.out.print("Customer Name: > ");
		String name = sc.next();

		sys.addCustomer(new Customer(id, name));
		System.out.printf("Added customer %s (ID: %s)\n", name, id);

	}

	private static void listToggleDiscounts(Scanner sc, WarehouseSystem sys) {//almost done
		// print discount list
		int i = 0;
		for (Discount d : sys.getDiscounts()) {
			System.out.printf("%d) %s\n", i, d.detailsTail());
			i++;
		}
		System.out.print("Enter index to toggle (blank to skip): > ");
		int index = sc.nextInt();
		Discount currentD = sys.getDiscounts().get(index);
		currentD.setActive(!sys.getDiscounts().get(index).isActive());
		for(Discount d : sys.getDiscounts()) {
			if(Discount.overlaps(currentD, d)) {
				d.setActive(false);
			}
		}
	}

	private static void createDiscount(Scanner sc, WarehouseSystem sys) {//DONE

		// prints the menu and saves the needed data in variables
		System.out.print("Type: 1) Fixed Amount 2) Percentage\n> ");
		int choice = sc.nextInt();
		System.out.print("Code/Name: > ");
		String code = sc.next();
		System.out.print("Start date (YYYY-MM-DD): > ");
		LocalDate start = LocalDate.parse(sc.next());
		System.out.print("End date (YYYY-MM-DD): > ");
		LocalDate end = LocalDate.parse(sc.next());
		System.out.print("Create as Active? (y/n): > ");
		boolean active = (sc.next().toLowerCase().equals("y")) ? true : false;

		// prints a different success message for each discount type
		do {
			switch (choice) {
			case 1 -> {
				System.out.print("Amount (e.g., 10 for 10 QAR): > ");
				double amount = sc.nextDouble();
				sys.addDiscount(new FixedAmountDiscount(code, start, end, active, amount));
			}
			case 2 -> {
				System.out.print("Percent (e.g., 10 for 10%): > ");
				double percent = sc.nextDouble();
				sys.addDiscount(new PercentageDiscount(code, start, end, active, percent));
			}
			default -> {
				System.out.println("Invalid Discount type\n");
				choice = 0;
			}
			}
		} while (choice == 0);

	}

	private static void addProduct(Scanner sc, WarehouseSystem sys) {//DONE

		// prints the menu and saves the needed data in variables
		System.out.println("Category: 1) Book 2) Electronic 3) Grocery\n> ");
		int choice = sc.nextInt();
		System.out.print("ID: > ");
		String id = sc.next();
		System.out.print("Name: > ");
		String name = sc.next();
		System.out.printf("Price (%s): > ", App.currency);// shows the currency (remove if currency never changes)
		double price = sc.nextDouble();
		System.out.print("Weight (Kg): > ");
		double weight = sc.nextDouble();
		System.out.print("Stock Qty: > ");
		int stock = sc.nextInt();

		// depending on the choice, creates the appropriate object and adds it to the
		// ArrayList
		switch (choice) {
		case 1 -> {
			sys.addProduct(new BookProduct(id, name, App.currency, price, weight, stock));
			System.out.printf("Product added: %s (Book)\n", name);
		}
		case 2 -> {
			sys.addProduct(new ElectronicProduct(id, name, App.currency, price, weight, stock));
			System.out.printf("Product added: %s (Electronic)\n", name);
		}
		case 3 -> {
			sys.addProduct(new GroceryProduct(id, name, App.currency, price, weight, stock));
			System.out.printf("Product added: %s (Grocery)\n", name);
		}
		default -> System.out.println("Invalid product category\n");

		}
	}

	private static void updateShipment(Scanner sc, WarehouseSystem sys) {//DONE
		// prints all shipments
		int i = 0;
		for (Shipment sh : sys.getShipments()) {
			System.out.printf("%d) %s\n", i, sh.allShipments());
			i++;
		}

		// user chooses the shipment intended to be updated
		System.out.print("Choose shipment index: > ");
		int index = sc.nextInt();

		// updates the status
		int status = 0;
		do {
			System.out.print("Status:\n" + "0) CREATED\n" + "1) PACKED\n" + "2) IN_TRANSIT\n" + "3) OUT_FOR_DELIVERY\n"
					+ "4) DELIVERED\n" + "New status index: > ");
			status = sc.nextInt();

			switch (status) {
			case 0 -> sys.getShipments().get(index).setStatus(ShipmentStatus.CREATED);
			case 1 -> sys.getShipments().get(index).setStatus(ShipmentStatus.PACKED);
			case 2 -> sys.getShipments().get(index).setStatus(ShipmentStatus.IN_TRANSIT);
			case 3 -> sys.getShipments().get(index).setStatus(ShipmentStatus.OUT_FOR_DELIVERY);
			case 4 -> sys.getShipments().get(index).setStatus(ShipmentStatus.DELIVERED);
			default -> {
				System.out.println("Invalid shipment status\n");
				status = 5;
			}
			}
		} while (status == 5);

		System.out.println(sys.getShipments().get(index).allShipments());
	}

}
