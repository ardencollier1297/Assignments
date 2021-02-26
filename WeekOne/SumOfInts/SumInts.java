/**
 * 
 */
package com.arden;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Arden
 * Program that takes five numbers as inputs from user and returns the sum
 */
public class SumInts {
	// Day Two Assignment One - Return the sum of ints
	// Declare scanner, empty array, counter, and initialize sum at 0
	static Scanner prompt = new Scanner(System.in);
	static ArrayList<Double> nums = new ArrayList<Double>();
	static int counter = 5;
	static double sum = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPrompt();
		addTotal();
	}
	
	// Method that asks for a number and takes the number as an input (scanner takes as string)
	public static void printPrompt() {
		
		while (counter > 0) {
			System.out.println("Please enter a number: \r");
			String newPrompt = prompt.next();
			try {
				// Parses the string for a double and adds to array if successful
				double num = Double.parseDouble(newPrompt);
				nums.add(num);
				// Reduces the counter
				counter--;
				printPrompt();	
			} catch (Exception e) {
				// If a double is not parsed, the exception is handled and the prompt returns
				System.out.println("Sorry, please enter a number");
				printPrompt();
			}
		}
		
	}
	
	// Method that iterates over the array of nums and adds up the total
	public static void addTotal() {
		for(double i : nums) {
			sum+=i;
		}
		System.out.println("The total of these numbers is " + sum);
	}
}
