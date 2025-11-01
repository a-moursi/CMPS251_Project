
public abstract class Product {
	
	private String id;
	private String name;
	
	private String currency;
	
	private double price;
	private double weightKg;
	private int stockQty;
	
	//----------------------------
	
	protected Product(String id, String name, String currency, double price, double weightKg, int stockQty) {
		this.id = id;
		this.name = name;
		this.currency = currency;
		this.setPrice(price);
		this.setWeightKg(weightKg);
		this.setStock(stockQty);
	}
	
	//----------------------------
	
	public abstract String getCategory();
	//same method exists in all categories
	
	//---------------------------------
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) { 
		if(price > 0) {
			this.price = price;
		}
	}
	
	public double getWeightKg() {
		return weightKg;
	}
	
	public void setWeightKg(double weightKg) {
		if(weightKg > 0) {
			this.weightKg = weightKg;
		}
	}
	
	public int getStock() {
		return stockQty;
	}
	
	public void setStock(int stockQty) {
		if(weightKg > 0) {
			this.stockQty = stockQty;
		}
		
	}
	
	//-------------------------------------
	
	public String basicInfo() {
		String info = String.format("test%s", name);
				
		return info;
	}
	
}
