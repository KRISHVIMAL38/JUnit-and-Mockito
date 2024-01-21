package healthycoderapp;

public class DietPlanner {
	private int protien;
	private int fat;
	private int carb;
	
	public DietPlanner(int protien, int fat, int carb) {
		super();
		
		if(protien+carb+fat!=100) {
			throw new ArithmeticException("fat ,carb, and protien must be add up to 100");
		}
		this.protien = protien;
		this.fat = fat;
		this.carb = carb;
	}
	
	public DietPlan calculateDietPlan(Coder coder) {
		int calories=this.calculateBMR(coder);
		int protien=this.calculateProtien(calories);
		int fat=this.calculateFat(calories);
		int carb=this.calculateCarb(calories);
		
		return new DietPlan(calories,protien,fat,carb);
	}

	private int calculateCarb(int bmr) {
		return (int)Math.round(bmr*carb/400.0);
	}
	
	private int calculateFat(int bmr) {
		return (int)Math.round(bmr*fat/400.0);
	}

	private int calculateProtien(int bmr) {
		return (int)Math.round(bmr*protien/400.0);
	}

	private int calculateBMR(Coder coder) {
		if(coder.getGender()==Gender.MALE) {
			return (int)Math.round(66.5+13.8*coder.getWeight()
			+5.0*coder.getHeight()*100
			-6.8*coder.getAge()*1.2
				);
		}
		return (int)Math.round(665.1+9.6*coder.getWeight()
		+1.9*coder.getHeight()*100
		-4.7*coder.getAge()*1.2
			);
	}
}
