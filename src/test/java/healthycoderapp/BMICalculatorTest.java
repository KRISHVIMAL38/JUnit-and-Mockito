package healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import junit.framework.Assert;

class BMICalculatorTest {

	//best name for this will be should_return_true_when_diet_recommanded
	/*
	 * @ParameterizedTest
	 * 
	 * @ValueSource(doubles = {89.0, 95.0, 110.0}) void isDietRecommandedTest(Double
	 * tmp) { //follow the rule == given == when == then //given double weight=tmp;
	 * double height=1.72; //when boolean
	 * res=BMICalculator.isDietRecommended(weight, height);
	 * 
	 * //then assertTrue(res); }
	 */
	
	
	/*
	 * @ParameterizedTest(name="weight={0},height={1}")
	 * 
	 * @CsvSource(value= {"89.0,1.62","95.0,1.75","110.0,1.78"}) void
	 * isDietRecommandedTest(Double tmp,Double tmp1) { //follow the rule == given ==
	 * when == then //given double weight=tmp; double height=tmp1; //when boolean
	 * res=BMICalculator.isDietRecommended(weight, height);
	 * 
	 * //then assertTrue(res); }
	 */
	
	//paste the file in src test resorces (the ending one)
	@ParameterizedTest(name="weight={0},height={1}") 
	@CsvFileSource(resources="/diet-recommanded.csv", numLinesToSkip=1)
	void isDietRecommandedTest(Double tmp,Double tmp1) {
		//follow the rule  == given == when == then
		//given
		double weight=tmp;
		double height=tmp1;
		//when
		boolean res=BMICalculator.isDietRecommended(weight, height);
		
		//then
		assertTrue(res);
	}
	@Test
	void isHeightZeroTest() {
		//follow the rule  == given == when == then
		//given
		double weight=89.0;
		double height=0.0;
		
		//when
		Executable executable= ()-> BMICalculator.isDietRecommended(weight, height);
		
		//then
		assertThrows(ArithmeticException.class, executable);
	}
	
	@Test
	void worstBMICoderTest() {
		//given
		List<Coder>coders=new ArrayList<>();
		coders.add(new Coder(1.80,60.0));
		coders.add(new Coder(1.82,98.0));
		coders.add(new Coder(1.82,64.7));
		//when
		Coder worsrCoder=BMICalculator.findCoderWithWorstBMI(coders);
		
		//then
		
		//we are doing this because if one test case fails below test are not executed like a break statement
		assertAll(
		()-> assertEquals(1.82, worsrCoder.getHeight()),
		()-> assertEquals(98.0, worsrCoder.getWeight())
		);
	}
	//This is for dealing with null values
	
	@Test
	void isNullTest() {
		//given
		List<Coder>coders=new ArrayList<Coder>();
		
		//when
		Coder worsrCoder=BMICalculator.findCoderWithWorstBMI(coders);
		
		//then
		assertNull(worsrCoder);
	}
	
	//This is for executing a test multiple times
	@RepeatedTest(10)
	void isNullTest1() {
		//given
		List<Coder>coders=new ArrayList<Coder>();
		
		//when
		Coder worsrCoder=BMICalculator.findCoderWithWorstBMI(coders);
		
		//then
		assertNull(worsrCoder);
	}
	
	@Test
	void getBMIScoresTest() {
		//given
		List<Coder>coders=new ArrayList<Coder>();
		coders.add(new Coder(1.80,60.0));
		coders.add(new Coder(1.82,98.0));
		coders.add(new Coder(1.82,64.7));
		double expected[]= {18.52,29.59,19.53};
		
		//when
		double[] bmiscores=BMICalculator.getBMIScores(coders);
		
		//then
		assertArrayEquals(expected, bmiscores);
	}
	/*
	 * @Test void
	 * should_ReturnCoderWithWorstBMIIn1MS_When_CoderListHas1000Elements() { //given
	 * List<Coder>coders=new ArrayList<>(); for(int i=0;i<10000;i++) {
	 * coders.add(new Coder(1.0+i,10.0+i)); } //when Executable executable=()
	 * ->BMICalculator.findCoderWithWorstBMI(coders);
	 * 
	 * //then assertTimeout(Duration.ofMillis(1), executable); }
	 */
	
	//Assumptions--->
	//Suppose we want to execute some tests only in specific environment like production
	//Then we use assumptions
	
	private String environment="dev";
	@Test
	void should_ReturnCoderWithWorstBMIIn1MS_When_CoderListHas1000Element() {
		//given
		
		//This Test is executed only in production not in dev
		assumeTrue(this.environment.equals("prod"));
		List<Coder>coders=new ArrayList<>();
		for(int i=0;i<10000;i++) {
			coders.add(new Coder(1.0+i,10.0+i));
		}
		//when
		Executable executable=() ->BMICalculator.findCoderWithWorstBMI(coders);
		
		//then
		assertTimeout(Duration.ofMillis(1), executable);
	}
	
	//@Nested
	//When we wanna organised test of particuler class in single unit
	@Nested
	class isDietRecommanded{
		//Put all the methods related to this method is this class
	}
	
	//To display a custom name to the test
	//@Test
	//@DisplayName("Name you wanna print on console")
	//method declaration
	
	//To skip a test like a break
	//@Disabled
	
	//To skip on perticuler operating system
	//@Disabled(OS.WINDOWS)
}
