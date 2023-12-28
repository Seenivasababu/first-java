package com.ecommerce.Ecommerce;

public class Practice {

	// 1. Addition
	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException();
		}
		return a / b;
	}

	public long factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Factorial is not defined for negative numbers");
		}
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public double power(double base, int exponent) {
		return Math.pow(base, exponent);
	}

	public double squareRoot(double number) {
		if (number < 0) {
			throw new IllegalArgumentException("Square root is not defined for negative numbers");
		}
		return Math.sqrt(number);
	}

	public int absoluteValue(int number) {
		return Math.abs(number);
	}

	public boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public String reverseString(String input) {
		return new StringBuilder(input).reverse().toString();
	}

	public String concatenateStrings(String str1, String str2) {
		return str1 + str2;
	}

	public boolean isPalindrome(String str) {
		String reversed = new StringBuilder(str).reverse().toString();
		return str.equals(reversed);
	}

	public int countWords(String sentence) {
		String[] words = sentence.split("\\s+");
		return words.length;
	}

	public double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}

	public double celsiusToFahrenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}

	public boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		}
		return false;
	}
	
	 public String getDayOfWeek(int day) {
	        switch (day) {
	            case 1: return "Sunday";
	            case 2: return "Monday";
	            case 3: return "Tuesday";
	            case 4: return "Wednesday";
	            case 5: return "Thursday";
	            case 6: return "Friday";
	            case 7: return "Saturday";
	            default: return "Invalid day";
	        }
	    }
	 
	 public String decimalToBinary(int decimal) {
	        return Integer.toBinaryString(decimal);
	    }
	 
	 public int findMax(int[] array) {
	        if (array.length == 0) {
	            throw new IllegalArgumentException("Array is empty");
	        }
	        int max = array[0];
	        for (int num : array) {
	            if (num > max) {
	                max = num;
	            }
	        }
	        return max;
	    }
	 
	 public double calculateAverage(int[] array) {
	        if (array.length == 0) {
	            throw new IllegalArgumentException("Array is empty");
	        }
	        int sum = 0;
	        for (int num : array) {
	            sum += num;
	        }
	        return (double) sum / array.length;
	    }
}
