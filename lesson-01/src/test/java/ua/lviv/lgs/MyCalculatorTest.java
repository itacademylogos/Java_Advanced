package ua.lviv.lgs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class MyCalculatorTest {

	private MyCalculator myCalculator;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED--> " + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED--> " + description.getMethodName());
		};
	};

	@Before
	public void beforeTest() {
		myCalculator = new MyCalculator();
	}

	@After
	public void afterTest() {
		myCalculator = null;
	}

	@Test
	public void addTest() {
		int realSum = myCalculator.add(5, 3);
		int expectedSum = 8;
		Assert.assertEquals(expectedSum, realSum);
	}

	@Test
	public void substractTest() {
		int realSubstraction = myCalculator.substract(10, 3);
		int expectedSubstraction = 7;

		Assert.assertEquals(expectedSubstraction, realSubstraction);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void substractWithExceptionTest() {
		int realSubstraction = myCalculator.substract(1, 3);
		int expectedSubstraction = -2;

		Assert.assertEquals(expectedSubstraction, realSubstraction);
	}
	
	@Test
	public void multiplyTest() {
			int multipliedValue = myCalculator.multiply(5, 7);
			int expectedValue = 35;
			Assert.assertEquals(expectedValue, multipliedValue);
	}

	@Test
	public void devideTest() {
			int devidedValue = myCalculator.devide(10, 2);
			int expectedValue = 5;
			Assert.assertEquals(expectedValue, devidedValue);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void devideWithExceptionTest() {
			int devidedValue = myCalculator.devide(10, 0);
			int expectedValue = 5;
			Assert.assertEquals(expectedValue, devidedValue);
	}
}
