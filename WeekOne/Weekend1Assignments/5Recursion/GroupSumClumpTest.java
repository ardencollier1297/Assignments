package com.arden.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.arden.GroupSumClump;

public class GroupSumClumpTest {

	List<Integer> nums = Arrays.asList(2, null, 16, 24, 19);
	List<Integer> numsTwo = Arrays.asList(7, 3, 4);
	List<Integer> numsThree = Arrays.asList(4, 4, 17);
	
	@Test(expected = NullPointerException.class)
	public void exception() {
	    GroupSumClump.groupSumClump(0, nums, 12);
	}
	
	@Test
	public void groupSumClumpTest() {
		assertFalse(GroupSumClump.groupSumClump(0, numsTwo, 15));
		assertTrue(GroupSumClump.groupSumClump(0, numsThree, 25));
	}
}
