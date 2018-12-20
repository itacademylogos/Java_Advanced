package ua.lviv.lgs;

public class MyCalculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int substract(int a, int b) {
		if (a < b)
			throw new IllegalArgumentException("a must be greater that b");

		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int devide(int a, int b) {
		if (b == 0)
			throw new IllegalArgumentException("b must not be equal to 0");
		return a / b;
	}

}
