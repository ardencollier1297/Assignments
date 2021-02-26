/**
 * 
 */
package com.arden;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Arden
 *
 * Program that accepts an entered character or string and returns
 * number of times it appears in a file
 *
 */
public class CountInstancesOfChar {

	// Day 3 Assignment 3
	public static void main(String[] args) throws IOException {
		
		// Initialize scanner and accept string as input
		Scanner prompt = new Scanner(System.in);
		String answer = prompt.next();
		prompt.close();
		
		// Initialize count as 0
		int count = 0;
		
		BufferedReader br = null;
		try {
			
			// Using a file titled "output.txt", uses relative path 
			// /Users/jadearden/Documents/Java/CountInstancesOfChars/output.txt
			String fileName = "output.txt";
			br = new BufferedReader(new FileReader(fileName));
			
			String s;
			
			// Reads file and separates the lines and strings into an array
			while ((s = br.readLine()) != null) {
				String[] stringsAr = s.split(" ");
				
				// Iterates over each entry and counts the number of times the answer appears
				for (String i : stringsAr) {
					if(i.contains(answer)) {
						count++;
					}
				}
			}	
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong...");
		} finally {
			// Close the BufferedReader
			br.close();
		}
		
		// Show the count in console
		System.out.println(count);
	}

}
