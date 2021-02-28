package com.arden.test;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.arden.EvenOddNum;
import static org.junit.Assert.assertEquals;

public class EvenOddNumTest {
	
	List<Integer> nums = Arrays.asList(3, 44);
	List<Integer> numsTwo = Arrays.asList(23, 1001, 58, 107);
	
	@Test
	public void evenOddNumsTest() {
		assertEquals("o3,e44", EvenOddNum.evenOddNums(nums));
		assertEquals("o23,o1001,e58,o107", EvenOddNum.evenOddNums(numsTwo));
	}

}
