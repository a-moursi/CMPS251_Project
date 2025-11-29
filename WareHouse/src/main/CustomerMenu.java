package main;

import java.util.ArrayList;
import java.util.Scanner;

import Discount.Discount;
import Orders.Order;
import Orders.OrderItem;
import PaymentSystem.*;
import Products.Product;
import Products.ProductListView;
import Shipment.*;

//Name: Abdelrahman Moursi
//ID: 202406103

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
			case 2 -> {// checks if the quantity is available, and then subtract that qnty from
						// the stock, before adding item to cart
				System.out.print("Enter Product ID: > ");
				String pId = sc.next();
				System.out.print("Quantity: > ");
				int qnty = sc.nextInt();
				Product added = sys.findProductById(pId);
				if (added.getStock() >= qnty) {
					added.setStock(added.getStock() - qnty);// subtract from the available stock
					currentC.shoppingcart.addItem(sys.findProductById(pId), qnty);// add to cart
				} else {
					System.out.println("Stock is not enough!");
				}

			} // DONE
			case 3 -> {// adds the qnty from the cart back to the stock, before removing the item
				currentC.shoppingcart.print();
				System.out.print("Enter index: > ");
				int index = sc.nextInt();
				CartItem removedItem = currentC.shoppingcart.getItems().get(index);
				Product removed = currentC.shoppingcart.getItems().get(index).getProduct();

				removed.setStock(removed.getStock() + removedItem.getQuantity());// adds the qnty back to stock
				currentC.shoppingcart.removeIndex(index);// remove from cart
			}
			case 4 -> {// DONE
				if (currentC.shoppingcart.isEmpty())
					System.out.println("Cart is Empty!");
				else
					currentC.shoppingcart.print();

			}
			case 5 -> checkout(sc, sys, currentC);// checkout

			case 0 -> choice = 0;
			default -> System.out.println("Invalid choice!, try again (Customer Menu)");
			}
		} while (!(choice == 0));
	}

	private static void checkout(Scanner sc, WarehouseSystem sys, Customer customer) {
		System.out.print("--- Shipping Address ---\nStreet : > ");
		sc.nextLine();
		String street = sc.nextLine();
		System.out.print("City: > ");
		String city = sc.next();
		System.out.print("Country: > ");
		String country = sc.next();
		Address address = new Address(street, city, country);

		double subtotal = customer.shoppingcart.subtotal();
		Discount activeD = sys.findApplicableDiscount(App.TODAY);
		double discount = 0;
		if (!(activeD == null))
			discount = activeD.calculateDiscount(subtotal);

		double totalWeight = customer.shoppingcart.totalWeight();
		double shippingfee = sys.getRateTable().shippingFeeFor(totalWeight);
		double total = 0;
		if (discount > subtotal)
			discount = subtotal;
		total = (subtotal-discount)+shippingfee;
		System.out.print("Payment method: 1) Card 2) Cash\n> ");
		int choice = sc.nextInt();

		Payment payment = null;
		switch (choice) {
		case 1 -> {
			System.out.print("Card Holder Name: > ");
			String cName = sc.next();
			System.out.print("Card Number (masked ok): > ");
			String cNo = sc.next();
			payment = new CardPayment(App.currency, total, cName, cNo);
		}
		case 2 -> payment = new CashPayment(App.currency, total);
		}

		Order order = new Order(customer, customer.shoppingcart.toOrderItems(), subtotal, discount, shippingfee, total,
				activeD, payment);
		Shipment shipment = new Shipment(order.getId(), customer, address, totalWeight);
		sys.getOrders().add(order);
		sys.getShipments().add(shipment);

		System.out.println("\n--- Checkout Summary ---\n--- Cart ---");
		customer.shoppingcart.print();
		if (!(activeD == null))
			System.out.printf("%s : - %s %.2f\n", activeD.getDetails(), App.currency, discount);
		else
			System.out.println("No active Discounts");
		System.out.printf("Shipping (%.2f kg): %s %.2f\n", totalWeight, App.currency, shippingfee);
		System.out.printf("TOTAL: %s %.2f\n", App.currency, total);
		System.out.printf("Payment: %s\n", payment.summary());
		System.out.println(shipment.basicInfo());
		customer.shoppingcart.clear();
	}
}
