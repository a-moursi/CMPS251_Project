package Shipment;
public class RateTable {

	double[] maxWeights;
	
	double[] feesQar;
	

	public double shippingFeeFor(double totalWeightKg) {
		
		if (totalWeightKg <= 2) return 10.00;
		
		else if (totalWeightKg > 2 && totalWeightKg <= 5) return 20.00;
		
		else if (totalWeightKg > 5 && totalWeightKg <= 10) return 35.00;
		
		return 50.00;
		
	}
	
}
