package Data;

import Discount.*;
import main.*;
import Orders.*;
import Products.*;
import Shipment.*;


public  class ReportService {
	public static void runAllReports(WarehouseSystem s) {

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
		for (Product product: s.getProducts()) {
			sum += product.getPrice()*product.getStock();
		}
		
		

		
		
		
		
		System.out.println("[7] Orders Today (2025-10-24): ");  // Need to work on displaying the date
		
		System.out.println("Total: QAR" + sum);
		for (Order order : s.getOrders()) {
			System.out.printf("- %s |  %s  |  QAR  %.2f", order.getId(), padName(order.getCustomer().getName()), order.getTotal());
		}
		
		
		System.out.println("[8] Sales by Customer (QAR): ");
		
		
		for (Customer customer : s.getCustomers()) {
			System.out.printf("- %s:  |  QAR  %.2f", padName(customer.getName()), customer.shoppingcart.subtotal());
			
		}
		
		
		
		
		System.out.println("[9] Shipments by Status: ");
		
		for (Shipment shipment : s.getShipments()) {
			shipment.allShipments();
		}
		
		System.out.println("[10] Shipments not yet DELIVERED: ");
		
		for (Shipment shipment : s.getShipments()) {
			if (shipment.getStatus() != ShipmentStatus.DELIVERED) shipment.notDelivered();
		}
		
		
		
		System.out.println("[11] Simple Top-Selling (counts): ");
		
		
		
		System.out.println("[12] Total Revenue (QAR, all time): ");
		
		
		
		System.out.println("[13] Payments Summary (from Orders): ");
		
		System.out.println("[14] Discount Usage: ");
		
		System.out.println("[15] Active Discount Overlaps (today 2025-10-24): ");  // Need date to be formatted
		

		System.out.println("=== End of Reports === ");
		
		
	}
	
	
	
	private static String padName(String n) {
		
		
		return String.format("%-15s", n);
	}
}
