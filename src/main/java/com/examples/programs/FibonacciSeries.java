package com.examples.programs;

public class FibonacciSeries {

	public static void main(String[] args) {
        int noOfTerms=10;
		System.out.println("Febonacci sequence using iteration");
		// 1 1 2 3 5 8 13 21 34
		displayFibonacciSeries(noOfTerms);

		System.out.println("\nFebonacci sequence using recursion");
		// 1 1 2 3 5 8 13 21 34
		for (int i = 1; i <= noOfTerms; i++) {
			int fibonnaciValue = fibonnaciValueUsingRecursion(i);
			System.out.print(fibonnaciValue + "\t");
		}
	}

	private static int fibonnaciValueUsingRecursion(int number) {
		if (number < 0) {
			return -1;// return error/exception;
		}
		if (number == 1) {
			return number;
		}
		if (number == 2) {
			return number - 1;
		}
		return fibonnaciValueUsingRecursion(number - 2) + fibonnaciValueUsingRecursion(number - 1);
	}

	private static void displayFibonacciSeries(int maxNumber) {
		int number = 1;
		int temp = 0;
		int sum = 0;
		for (int i = 1; i <= maxNumber; i++) {
			sum = 0;
			if (i == 1) {
				number = 1;
			} else {
				sum = number + temp;
				temp = number;
				number = sum;
			}
			System.out.print(number + "\t");
		}
	}

}
