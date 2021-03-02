/**
 * 
 */
package com.arden;

import java.util.List;

/**
 * @author Arden
 *
 * Program that takes a list of integers and returns whether or not 
 * a group can be chosen that adds up to a specified target 
 *
 */

public class GroupSumClump {

	// Weekend 1 Assignment 5
	public static boolean groupSumClump(Integer start, List<Integer> nums, Integer target) {
		try {
			// Checks if counter has reached or exceeded the bounds of the array,
			// if so, returns whether or not the target has been met
	        if (start >= nums.size()) return target == 0;
	        
	        // Initialize a total that is summed up during each iteration
	        int total = nums.get(start++);
	        
	        // Loop begins if there are duplicate adjacent numbers and adds each to the total, 
	        // treating the adjacent numbers as one number
	        while (nums.size() > start && nums.get(start - 1) == nums.get(start)) {total += nums.get(start++); };
	        
	        // Recursively iterates through the loop - creating trees that reduce the target by the current total
	        // and returns whether or not the first statement returns true
	        if ((groupSumClump(start, nums, target - total)) || (groupSumClump(start, nums, target))) {
	        	return true;
	        } else {
	        	return false;
	        }
		} catch (Exception e) {
			System.out.println("Sorry, it looks like there was an issue...");
			System.exit(0);
			return false;
		}
	}

}
