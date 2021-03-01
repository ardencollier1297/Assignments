/**
 * 
 */
package com.arden;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Arden
 *
 * Program that uses lambdas to each various sortings of a list of Strings
 *
 */
public class Lambdas {

	// Day 5 Assignment 1
	public static void main(String[] args) {
		
		// Declare list of Strings
		List<String> strs = Arrays.asList("Charlie", "Dee", "Frank", "Dennis", "Mac");
		
		// Declare array of Strings (used for second "hasE")
		String[] secondStrs = {"Apple", "Banana", "Orange", "Kiwi", "Grape"};

		// Lambda for returning the List sorted by shortest to longest
		ISort shortToLong = (arr) -> System.out.println(arr.stream()
				.sorted((String o1, String o2) -> o1.length() - o2.length())
				.collect(Collectors.toList()));
		
		// Lambda for returning the List sorted by longest to shortest
		ISort longToShort = (arr) -> System.out.println(arr.stream()
				.sorted((String o1, String o2) -> o2.length() - o1.length())
				.collect(Collectors.toList()));
		
		// Lambda for returning the List alphabetically
		ISort alpha = (arr) -> System.out.println(arr.stream()
				.sorted((String o1, String o2) -> o1.charAt(0) - o2.charAt(0))
				.collect(Collectors.toList()));
		
		// Lambda for returning the List with Strings that have "e" first
		ISort hasE = (arr) -> System.out.println(arr.stream()
				.sorted((String o1, String o2) ->  (o1.contains("e") ? -1 : 0))
				.collect(Collectors.toList()));
		
		System.out.println("Shortest to longest:");
		shortToLong.sortStrings(strs);
		System.out.println("Longest to shortest:");
		longToShort.sortStrings(strs);
		System.out.println("Alphabetically:");
		alpha.sortStrings(strs);
		System.out.println("Has E first:");
		System.out.println("Solution 1:");
		hasE.sortStrings(strs);
		Arrays.sort(secondStrs, (s1, s2) -> hasEHelper(s1, s2));
		System.out.println("Solution 2:");
		System.out.println(Arrays.stream(secondStrs).collect(Collectors.toList()));
	}
	
	// Helper method that operates similarly to the lambda, used for an array
	private static int hasEHelper(String o1, String o2) {
		if (o1.contains("e")) {
			return -1;
		}  
		return 0;
	};
}


