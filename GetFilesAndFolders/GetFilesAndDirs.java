/**
 * 
 */
package com.arden;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;


/**
 * @author Arden
 *
 * Program that gets a list of all files/directories under a given directory
 *
 */
public class GetFilesAndDirs {

	// Day 3 Assignment 1	 
	public static void main(String[] args) throws IOException {
		
		// Initialize scanner - accept input for directory
		System.out.println("Please enter a directory you would like to view: \r");
		Scanner prompt = new Scanner(System.in);
		String directory = prompt.next();
		
		prompt.close();
		listFilesAndDirs(directory);
	}
	
	public static void listFilesAndDirs(String directory) {
		
		// Initialize a file with the name of the entered directory
		File dir = new File(directory);
	    File[] files = dir.listFiles();

	    // Checks if a directory or file exists and prints the name
	    if (files != null && files.length > 0) {
	    	for (File file : files) {   
	    		listFilesAndDirs(file.getAbsolutePath());
	    		System.out.println(file);
	        }
	    }
	}
}
