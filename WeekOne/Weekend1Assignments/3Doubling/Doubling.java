/**
 * 
 */
package com.arden;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arden
 *
 * Function that takes a list of integers and returns a list with the integers doubled
 *
 */
public class Doubling {

	// Weekend 1 Assignment 3
	public static List<Integer> doubling(List<Integer> nums) {
		return nums.stream().map(s -> s*2).collect(Collectors.toList());
	}
}
