/**
 * 
 */
package com.arden;

/**
 * @author Arden
 *
 */
public class WeekendLambdas {

	// Weekend 1 Assignment 1
	public static void main(String[] args) {
		// Lambda that returns if a number is odd or even
		IIsOddInterface isOddInterface = (a) -> System.out.println(a % 2 == 0 ? "EVEN" : "ODD" );
		
		// Lambda that returns if a number is odd or even
		IIsPrime isPrimeInterface = (a) -> {
			for (int i = 2; i < a; i++) {
				if (a % i == 0) {
					System.out.println("COMPOSITE");
					return;
				}
			}
			System.out.println("PRIME");
		};
		
		// Lambda that returns if a number is a palindrome
		IIsPalindrome isPalindromeInterface = (a) -> {
			String b = a.toString();
			int first = 0;
			int last = b.length() - 1;
			
			while(last > first) {
				if(b.charAt(last) != b.charAt(first)) {
					System.out.println("NOT A PALINDROME");
					return;
				}
				  
				first++;
				last--;
			}
			System.out.println("PALINDROME");
		};
	
		isOddInterface.isOdd(4);
		isPrimeInterface.isPrime(5);
		isPalindromeInterface.isPalindrome(898);
		isOddInterface.isOdd(3);
		isPrimeInterface.isPrime(12);

	}

}
