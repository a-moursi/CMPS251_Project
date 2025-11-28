package Data;

import java.util.ArrayList;
import java.util.Scanner;

import Discount.*;
import main.*;
import Orders.*;
import PaymentSystem.CashPayment;
import Products.*;
import Shipment.*;

public class ReportService {

	public static void runAllReports(WarehouseSystem sys, Scanner sc) {
		
		int choice=0;
		do {
		System.out.print("\n=====Reports Menu=====\r\n" + "1) All Discounts \r\n" + "2) Active Discounts (today) \r\n"
				+ "3) Products by Category \r\n" + "4) Low Stock (≤ threshold) \r\n" + "5) Out of Stock \r\n"
				+ "6) Inventory Valuation (QAR) \r\n" + "7) Orders Today (YYYY-MM-DD) \r\n"
				+ "8) Sales by Customer (QAR) \r\n" + "9) Shipments by Status \r\n"
				+ "10) Shipments are not yet DELIVERED \r\n" + "11) Simple Top-Selling (counts) \r\n"
				+ "12) Total Revenue (QAR, all time) \r\n" + "13) Payments Summary (from Orders) \r\n"
				+ "14) Discount Usage \r\n" + "15) Active Discount Overlaps (today) \r\n" + "0) Exit \r\n"
						+ "Choice : > ");

		choice = sc.nextInt();
		switch (choice) {
		case 1 -> {
			System.out.printf("[1] All Discounts: \n");
			for (Discount discount : sys.getDiscounts())
				discount.detailsTail();
		}
		case 2 -> {
			System.out.printf("[2] Active Dicounts  (today %s): \n", sys.today()); // need to display day and full date
			for (Discount discount : sys.getDiscounts())
				if (discount.isActive())
					discount.ActiveDiscounts();
		}
		case 3 -> {
			System.out.printf("[3] Products by Category:\r\n");
			ProductListView.printCategorized(sys.getProducts());
		}
		case 4 -> {
			System.out.println("[4] Low Stock (<= 5): ");
			for (Product product : sys.getProducts())
				if (product.getStock() <= 5)
					System.out.println(product.basicInfo());
		}
		case 5 -> {
			System.out.println("[5] Out of Stock: ");
			boolean outOfStock = false;
			for (Product product : sys.getProducts()) {
				if (product.getStock() == 0) {
					System.out.println(product.basicInfo());
					outOfStock = true;
				}

			}
			if (!outOfStock)
				System.out.println("None.");
		}
		case 6 -> {
			System.out.println("[6] Inventory Valuation (QAR): ");
			double sum = 0;
			for (Product product : sys.getProducts()) {
				sum += product.getPrice() * product.getStock();
			}
			System.out.println("Total: QAR" + sum);
		}
		case 7 -> {
			System.out.println("[7] Orders Today (2025-10-24): "); // Need to work on displaying the date
			for (Order order : sys.getOrders()) {
				if (order.getDate().equals(sys.today())) {
					System.out.printf("- %s |  %s  |  QAR  %.2f", order.getId(), padName(order.getCustomer().getName()),
							order.getTotal());
				}
			}
		}
		case 8 -> {
			System.out.println("[8] Sales by Customer (QAR): ");
			for (Customer customer : sys.getCustomers()) {
				double customerTotal = 0;
				for (Order order : sys.getOrders()) {
					if (order.getCustomer().getId().equals(customer.getId())) {
						customerTotal += order.getTotal();
					}

				}

				System.out.printf("- %s:  |  QAR  %.2f", padName(customer.getName()), customerTotal);

			}

		}
		case 9 -> {
			System.out.println("[9] Shipments by Status: ");
			for (Shipment shipment : sys.getShipments()) {
				shipment.allShipments();
			}
		}
		case 10 -> {
			System.out.println("[10] Shipments not yet DELIVERED: ");
			for (Shipment shipment : sys.getShipments()) {
				if (shipment.getStatus() != ShipmentStatus.DELIVERED)
					shipment.notDelivered();
			}
		}
		case 11 -> {
			System.out.println("[11] Simple Top-Selling (counts): ");
			ArrayList<Product> sortedList = new ArrayList<>(sys.getProducts());
			sortedList.sort((p1, p2) -> {
				int count1 = getSalesCount(p1, sys); // gets quantity sold of p1
				int count2 = getSalesCount(p2, sys); // gets quantity sold of p2
				return Integer.compare(count2, count1);
				// count2 is placed first so that it sorts in descending order
			});
			for (Product p : sortedList) {
				int count = getSalesCount(p, sys);
				if (count > 0) {
					String label = (count == 1) ? "unit" : "units";
					System.out.printf("-%s (%s): %d %s\n", p.getName(), p.getId(), count, label);
				}
			}
		}
		case 12 -> {
			System.out.println("[12] Total Revenue (QAR, all time): ");
			double totalRevenue = 0;
			for (Order order : sys.getOrders()) {
				totalRevenue += order.getTotal();
			}
			System.out.printf("Total: QAR %.2f \n", totalRevenue);
		}
		case 13 -> {
			System.out.println("[13] Payments Summary (from Orders): ");
			double totalPayment = 0;
			ArrayList<String> card = new ArrayList<>();
			ArrayList<String> cash = new ArrayList<>();
			String CashNames = cash.toString().replace("[", "").replace("]", "");
			String CardNames = card.toString().replace("[", "").replace("]", "");
			for (Order order : sys.getOrders()) {
				totalPayment += order.getTotal();
				if (order.getPayment() instanceof CashPayment)
					cash.add(order.getCustomer().getName());
				else
					card.add(order.getCustomer().getName());
			}
			System.out.printf("Total: QAR %.2f \n", totalPayment);
			System.out.printf("(mix: card for %s; cash for %s) \n", CardNames, CashNames);
		}
		case 14 -> {
			System.out.println("[14] Discount Usage: ");
			for (Order orders : sys.getOrders()) {
				Discount d1 = orders.getAppliedDiscount();
				String name = d1.getCode();
				int times = 0;
				double total = 0;
				for (Order order : sys.getOrders()) {
					if (order.getAppliedDiscount() == d1) {
						total += order.getDiscountAmount();
						times += 1;
					}
				}
				System.out.printf("- %s:   times %d, total discount QAR %.2f \n", name, times, total);
			}
		}
		case 15 -> {
			System.out.printf("[15] Active Discount Overlaps (today %s): \n", sys.today()); // Need date to be formatted
			for (Discount discount : sys.getDiscounts()) {
				if (discount.isActive() && discount.getStartDate().isAfter(sys.today())
						&& discount.getEndDate().isBefore(sys.today()))
					discount.ActiveDiscounts();
			}
			System.out.println("=== End of Reports === ");
		}
		case 0 -> choice=0;

		default -> System.out.println("Invalid choice");
		}}while(choice!=0);

	}

	private static String padName(String n) {

		return String.format("%-15s", n);
	}

	// helper method for this option
	public static int getSalesCount(Product p, WarehouseSystem s) {
		int count = 0;
		for (Order order : s.getOrders()) { // checking orders because it stores all the final orders
			for (OrderItem orderItem : order.getItems()) {
				if (orderItem.getProduct().getId().equals(p.getId())) {
					count += orderItem.getQuantity();
					break;
				}
			}
		}

		return count;
	}

}
