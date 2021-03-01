package com.arden.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.arden.Doubling;

public class DoublingTest {

	List<Integer> nums = Arrays.asList(1, 2, 3);
	List<Integer> nums2 = Arrays.asList(6, 8, 6, 8, -1);
	List<Integer> nums3 = Arrays.asList();
	List<Integer> numsTest = Arrays.asList(2, 4, 6);
	List<Integer> nums2Test = Arrays.asList(12, 16, 12, 16, -2);
	List<Integer> nums3Test = Arrays.asList();
	
	@Test
	public void doublingTest() {
		assertEquals(numsTest, Doubling.doubling(nums));
		assertEquals(nums2Test, Doubling.doubling(nums2));
		assertEquals(nums3Test, Doubling.doubling(nums3));
	}
}
