package healthycoderapp;

public class DietPlan {
	private int caleries;
	private int protien;
	private int fat;
	private int carbohydrate;
	
	public DietPlan(int caleries, int protien, int fat, int carbohydrate) {
		super();
		this.caleries = caleries;
		this.protien = protien;
		this.fat = fat;
		this.carbohydrate = carbohydrate;
	}

	@Override
	public String toString() {
		return "Diet [caleries=" + caleries + ", protien=" + protien + ", fat=" + fat + ", carbohydrate="
				+ carbohydrate + "]";
	}

	public int getCaleries() {
		return caleries;
	}

	public void setCaleries(int caleries) {
		this.caleries = caleries;
	}

	public int getProtien() {
		return protien;
	}

	public void setProtien(int protien) {
		this.protien = protien;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	
	
}
