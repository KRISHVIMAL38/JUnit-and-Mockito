package healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DietPlannerTest {

	private DietPlanner dietPlanner;
	
	@BeforeEach
	void setUp() {
		this.dietPlanner=new DietPlanner(20, 30, 50);
	}
	
	@AfterEach
	void go(){
		System.out.println("this is after each method");
	}
	@Test
	void correctPlan() {
		//given
		Coder coder=new Coder(1.82,75.0,26,Gender.MALE);
		DietPlan expected=new DietPlan(2202,110,73,275);
		
		//when
		DietPlan actual= dietPlanner.calculateDietPlan(coder);
		
		//then
		//This is helpful for camparing two objects
		assertAll(
			() -> assertEquals(expected.getCaleries(),actual.getCaleries()),
			() -> assertEquals(expected.getProtien(),actual.getProtien()),
			() -> assertEquals(expected.getCarbohydrate(),actual.getCarbohydrate()),
			() -> assertEquals(expected.getFat(),actual.getFat())
		);
	}

}
