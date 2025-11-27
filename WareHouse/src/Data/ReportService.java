package Data;

import java.util.ArrayList;

import Discount.*;
import main.*;
import Orders.*;
import Products.*;
import Shipment.*;

public class ReportService {
	public static void runAllReports(WarehouseSystem s) {


		System.out.println("1) All Discounts \r\n" + "2) Active Discounts (today) \r\n" + "3) Products by Category \r\n"
				+ "4) Low Stock (≤ threshold) \r\n" + "5) Out of Stock \r\n" + "6) Inventory Valuation (QAR) \r\n"
				+ "7) Orders Today (YYYY-MM-DD) \r\n" + "8) Sales by Customer (QAR) \r\n"
				+ "9) Shipments by Status \r\n" + "10) Shipments are not yet DELIVERED \r\n"
				+ "11) Simple Top-Selling (counts) \r\n" + "12) Total Revenue (QAR, all time) \r\n"
				+ "13) Payments Summary (from Orders) \r\n" + "14) Discount Usage \r\n"
				+ "15) Active Discount Overlaps (today) " + "\n\n\t\t === Reports Output (Staff) === ");


		System.out.println("1) All Discounts \r\n"
				+ "2) Active Discounts (today) \r\n"
				+ "3) Products by Category \r\n"
				+ "4) Low Stock (≤ threshold) \r\n"
				+ "5) Out of Stock \r\n"
				+ "6) Inventory Valuation (QAR) \r\n"
				+ "7) Orders Today (YYYY-MM-DD) \r\n"
				+ "8) Sales by Customer (QAR) \r\n"
				+ "9) Shipments by Status \r\n"
				+ "10) Shipments are not yet DELIVERED \r\n"
				+ "11) Simple Top-Selling (counts) \r\n"
				+ "12) Total Revenue (QAR, all time) \r\n"
				+ "13) Payments Summary (from Orders) \r\n"
				+ "14) Discount Usage \r\n"
				+ "15) Active Discount Overlaps (today) "
				+ "\n\n\t\t === Reports Output (Staff) === ");
		

		System.out.printf("[1] All Discounts: \n");

		for (Discount discount : s.getDiscounts()) {
			discount.detailsTail();
		}

		System.out.printf("[2] Active Dicounts:  \n"); // need to display day and full date

		for (Discount discount : s.getDiscounts()) {
			if (discount.isActive()) discount.ActiveDiscounts();
			
			}
		
		System.out.printf("[3] Products by Category:\r\n");

		ProductListView.printCategorized(s.getProducts());

		System.out.println("[4] Low Stock (<= 5): ");

		for (Product product : s.getProducts()) {
			if (product.getStock() <= 5) {
				System.out.println(product.basicInfo());
			}
		}

		System.out.println("[5] Out of Stock: ");
		boolean outOfStock = false;
		for (Product product : s.getProducts()) {
			if (product.getStock() == 0) {
				System.out.println(product.basicInfo());
				outOfStock = true;
			}

		}
		if (!outOfStock)
			System.out.println("None.");

		System.out.println("[6] Inventory Valuation (QAR): ");
		double sum = 0;
		for (Product product : s.getProducts()) {
			sum += product.getPrice() * product.getStock();
		}
		System.out.println("Total: QAR" + sum);
		
		System.out.println("[7] Orders Today (2025-10-24): "); // Need to work on displaying the date


		for (Order order : s.getOrders()) {
			if (order.getDate().equals(s.today())) {
			System.out.printf("- %s |  %s  |  QAR  %.2f", order.getId(), padName(order.getCustomer().getName()),
					order.getTotal());
			}
		}

		System.out.println("[8] Sales by Customer (QAR): ");
		for (Customer customer : s.getCustomers()) {
			double customerTotal = 0;
			for (Order order : s.getOrders()) {
				if (order.getCustomer().getId().equals(customer.getId())) {
					customerTotal += order.getTotal();
				}
				
			}
		
			System.out.printf("- %s:  |  QAR  %.2f", padName(customer.getName()), customerTotal);

		}

		System.out.println("[9] Shipments by Status: ");

		for (Shipment shipment : s.getShipments()) {
			shipment.allShipments();
		}

		System.out.println("[10] Shipments not yet DELIVERED: ");

		for (Shipment shipment : s.getShipments()) {
			if (shipment.getStatus() != ShipmentStatus.DELIVERED) shipment.notDelivered();
		}

		System.out.println("[11] Simple Top Selling (counts): ");
		
		ArrayList<Product> sortedList = new ArrayList<>(s.getProducts());
		
		
		sortedList.sort((p1,p2) -> {
			int count1 = getSalesCount(p1, s); // gets quantity sold of p1
			int count2 = getSalesCount(p2, s); // gets quantity sold of p2
			
			return Integer.compare(count2, count1);
			// count2 is placed first so that it sorts in descending order
			
		});
		
		
		
		for (Product p : sortedList) {
			int count = getSalesCount(p,s);
			if (count > 0) {
				String label = (count == 1) ? "unit" : "units";
				System.out.printf("-%s (%s): %d %s\n", p.getName(), p.getId(), count, label);

			}
		
			
		}
		

		

		System.out.println("[12] Total Revenue (QAR, all time): ");
		
		double totalRevenue = 0;
		for (Order order : s.getOrders()) {
			totalRevenue += order.getTotal();
		}
		System.out.printf("Total: QAR %.2f", totalRevenue);

		
		
		System.out.println("[13] Payments Summary (from Orders): ");
//		double totalPayment = 0;
//		for (Order order : s.getOrders()) {
//			totalPayment += order.
//		}
		

		System.out.println("[14] Discount Usage: ");
		
		

		System.out.println("[15] Active Discount Overlaps (today 2025-10-24): "); // Need date to be formatted
		

		System.out.println("=== End of Reports === ");

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
