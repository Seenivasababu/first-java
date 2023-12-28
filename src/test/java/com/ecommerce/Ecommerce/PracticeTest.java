package com.ecommerce.Ecommerce;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PracticeTest {

	Practice underTest = new Practice();

	@Test
	void addTwoNumbers() {
		int a = 10;
		int b = 12;
		int result = underTest.add(a, b);
		int expected = 22;
		assertThat(result).isEqualTo(expected);
	}

	@Test
	void subtractTwoNumbers() {
		int a = 10;
		int b = 12;
		int result = underTest.subtract(a, b);
		int expected = -2;
		assertThat(result).isEqualTo(expected);
	}

	@Test
	void multiplyTwoNumbers() {
		int a = 10;
		int b = 12;
		int result = underTest.multiply(a, b);
		int expected = 120;
		assertThat(result).isEqualTo(expected);
	}

	@Test
	void divideTwoNumbers() {
		int a = 24;
		int b = 12;
		int result = underTest.divide(a, b);
		int expected = 2;
		assertThat(result).isEqualTo(expected);

	}

	@Test
	void divideNumberWithZero() {
		int a = 24;
		int b = 0;

		assertThatIllegalArgumentException().isThrownBy(() -> underTest.divide(a, b));

	}

	@Test
	void checkFactorial() {
		int num = 5;
		long result = underTest.factorial(num);
		long expected = 120;
		assertThat(result).isEqualTo(expected);
	}

	@Test
	void checkFactorialForNegative() {
		int num = -1;
		assertThatIllegalArgumentException().isThrownBy(() -> underTest.factorial(num))
				.withMessage("Factorial is not defined for negative numbers");

	}
	
	@Test
	void powerTwoNumbers() {
		int base = 5;
		int exponent = 2;
		double result = underTest.power(base, exponent);
		int expected = 25;
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
	void checkSquareRoot() {
		double num = 25;
		double result = underTest.squareRoot(num);
		int expected = 5;
		assertThat(result).isEqualTo(expected);
	}
	@Test
	void checkAbsoluteNumber() {
		int num = 25;
		int result = underTest.absoluteValue(num);
		int expected = 25;
		assertThat(result).isEqualTo(expected);
		assertEquals(0, underTest.absoluteValue(0));
		assertEquals(2, underTest.absoluteValue(-2));
	}

	@Test
	void checkPrimeNumber() {
		int num = 25;
		boolean result = underTest.isPrime(num);
		boolean expected = false;
		assertThat(result).isEqualTo(expected);
		assertEquals(true, underTest.isPrime(5));
		assertEquals(true, underTest.isPrime(31));
	}
	
	@Test
	void reverseString() {
		String str = "hello";
		String result = underTest.reverseString(str);
		String expected = "olleh";
		assertEquals(expected, result);
	}
	
	@Test
	void concatenateString() {
		String str1 = "hello";
		String str2 = "World";
		String result = underTest.concatenateStrings(str1, str2);
		String expected = "helloWorld";
		assertEquals(expected, result);
	}
	
	@Test
	void isPalindrome() {
		String str = "racecar";
		boolean result = underTest.isPalindrome(str);
		boolean expected = true;
		assertEquals(expected, result);
		assertEquals(false, underTest.isPalindrome("hello"));
	}
	
	@Test
	void countWords() {
		String sentence = "Hi Hello guys";
		int result = underTest.countWords(sentence);
		int expected = 3;
		assertEquals(expected, result);
	}
	
	@Test
	void fahrenheitToCelsius() {
		double temp = 100;
		double result = underTest.fahrenheitToCelsius(temp);
		double expected = 37.7778;
		double delta = 0.0001;
		assertEquals(expected, result,delta);
	}
	
	@Test
	void celsiusToFahrenheit() {
		double temp = 39;
		double result = underTest.celsiusToFahrenheit(temp);
		double expected = 100;
		double delta = 3;
		assertEquals(expected, result,delta);
	}
	
	@Test
	void checkLeapYear() {
		int year = 2000;
		boolean result = underTest.isLeapYear(year);
		boolean expected = true;

		assertEquals(expected, result);
		assertEquals(false, underTest.isLeapYear(1997));
		assertEquals(false, underTest.isLeapYear(100));
	}
	@Test
	void dayOfWeek() {
		int day = 2;
		String result = underTest.getDayOfWeek(day);
		String expected = "Monday";
		assertEquals(expected, result);
		assertEquals("Invalid day", underTest.getDayOfWeek(8));
	}
	
	@Test
	void decimalToBinary() {
		int num =5;
		String result = underTest.decimalToBinary(num);
		String expected = "101";

		assertEquals(expected, result);
		
	}
	
	@Test
	void findMax() {
		int array[] = {2,1,5,3,4};
		int result = underTest.findMax(array);
		int expected = 5;
		assertEquals(expected, result);
		assertThatIllegalArgumentException().isThrownBy(() -> underTest.findMax(new int[] {}))
		.withMessage("Array is empty");

	}
	@Test
	void calculateAverage() {
		int array[] = {2,1,5,3,4};
		double result = underTest.calculateAverage(array);
		int expected = 3;
		assertEquals(expected, result);
		assertThatIllegalArgumentException().isThrownBy(() -> underTest.calculateAverage(new int[] {}))
		.withMessage("Array is empty");

	}
}
