/**
 * 
 */
package com.arden;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arden
 *
 */
public class RightDigit {

	// Weekend 1 Assignment 2
	public static List<Integer> findRight(List<Integer> nums) {
		List<Integer> rightNums = nums.stream().map(num -> num % 10).collect(Collectors.toList());
		return rightNums;
	}
}
