package com.arden.test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.arden.RightDigit;

public class RightDigitTest {
	
	List<Integer> nums = Arrays.asList(1, 22, 93);
	List<Integer> numsTwo = Arrays.asList(16, 8, 886, 1);
	List<Integer> numsThree = Arrays.asList(10, 0);
	List<Integer> numsTest = Arrays.asList(1, 2, 3);
	List<Integer> numsTwoTest = Arrays.asList(6, 8, 6, 1);
	List<Integer> numsThreeTest = Arrays.asList(0, 0);
	
	@Test
	public void rightDigitTest() {
		assertEquals(numsTest, RightDigit.findRight(nums));
		assertEquals(numsTwoTest, RightDigit.findRight(numsTwo));
		assertEquals(numsThreeTest, RightDigit.findRight(numsThree));
	}
	
}
