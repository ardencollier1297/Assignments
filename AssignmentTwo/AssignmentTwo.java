package com.arden;

import java.util.Scanner;

public class AssignmentTwo {

	public static void main(String[] args) {
		// Day One Assignment Two - Java
		
		// Declare counter and scanner
		int numGuesses = 5;
		Scanner prompt = new Scanner(System.in);
		
		// Generate random integer
		int min = 1;
		int max = 100;
		double randomDouble = Math.floor(Math.random() * (max - min + 1) + min);
		int randomInt = (int) randomDouble;
		
		// Prompt user to guess a number between 1 and 100
		System.out.println("Guess a number between 1 and 100");
		
	    while(numGuesses >= 0) {
	    	//Immediately exit program if user has run out of guesses
	    	
	    	if(numGuesses == 0) {
				System.out.println("Sorry! The number was " + randomInt);
				break;
			}
	    	
			// Take user input for guessed number
			int guess = prompt.nextByte();
			
			
			// Check if guess is within 10 numbers plus or minus the random number
			if(guess < (randomInt - 10) || guess > (randomInt + 10)) {
				System.out.println("Not quite... Please try again");
				// Decrease the number of guesses
				numGuesses--;
			} else {
				System.out.println("Great job! The number was " + randomInt);
				break;
			}
	    }
	    prompt.close();
	}

}
