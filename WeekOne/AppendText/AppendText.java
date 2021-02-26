/**
 * 
 */
package com.arden;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author Arden
 *
 * Program that appends text to a file
 *
 */
public class AppendText {

	// Day 3 Assignment 2 
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = null;
		try {
			// Declare the file name as a string - The initial file is simply a txt 
			// file with the text "Hello World!" - Uses relative path of the file
			String fileName = "output.txt";
			
			// Initialized my BufferedWriter with "true" set
			// for the boolean that is passed in to FileWriter
			// The boolean determined whether or not it will append (true) or overwrite (false)
			bw = new BufferedWriter(new FileWriter(fileName,true));
			bw.write("\nHere is some text I have added!");
			
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong...");
		} finally {
			// Close the BufferedWriter
			bw.close();
		}
	}
}
