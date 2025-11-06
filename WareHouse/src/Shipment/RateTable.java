package Shipment;

public class RateTable {

	private double[] maxWeights;

	private double[] feesQar;

	public RateTable(double[] maxWeights, double[] feesQar) {
		this.maxWeights = maxWeights;
		this.feesQar = feesQar;
	}

	public double shippingFeeFor(double totalWeightKg) {

		int i = 0;

		for (i = 0; i < maxWeights.length; i++) {

			if (totalWeightKg <= maxWeights[i])
				return feesQar[i];
		}

		return feesQar[feesQar.length - 1];
	}

}
