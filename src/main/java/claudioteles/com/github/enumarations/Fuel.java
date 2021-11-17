package claudioteles.com.github.enumarations;

public enum Fuel {
	
	PETROL("GASOLINA"), ALCOHOL("ÁLCOOL"), DIESEL("DIESEL"), FLEX("FLEX");
	
	private String fuel;

	private Fuel(String string) {
		this.fuel = string;
	}

	public String getFuel() {
		return fuel;
	}

}
