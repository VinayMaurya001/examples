package com.examples.programs;

public class EvenAndOddNumber {

	public static void main(String[] args) {
		String evenOrOdd = evenOrOdd(2);
		System.out.println(evenOrOdd);
		System.out.println(evenOrOdd(3));
	}

	private static String evenOrOdd(int num) {
		return num % 2 == 0?"Even":"Odd";
	}

}
