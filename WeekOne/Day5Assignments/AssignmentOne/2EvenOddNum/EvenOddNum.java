
package com.arden;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arden
 *
 * Program that returns a comma separated string based on a given list of integers
 * where each number is preceded by "e" if even or "o" if odd
 *
 */

public class EvenOddNum {

	// Day 5 Assignment 2
	public static String evenOddNums(List<Integer> numbers) {
		// Creates a new string by creating a stream from the numbers - uses a ternary to determine if
		// odd or even and prepends number with it - Collector joins the numbers at the end
		String evenOddNums = numbers.stream().map(s -> (s % 2 == 0 ? "e" : "o") + String.valueOf(s)).collect(Collectors.joining(","));
		return evenOddNums;
	}

}
