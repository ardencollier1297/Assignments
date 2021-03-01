package com.arden.test;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.arden.NoX;

public class NoXTest {

	List<String> strs = Arrays.asList("ax", "bb", "xc");
	List<String> strs2 = Arrays.asList("xxax", "xbxbx", "xxcx");
	List<String> strs3 = Arrays.asList("x");
	List<String> strsTest = Arrays.asList("a", "bb", "c");
	List<String> strs2Test = Arrays.asList("a", "bb", "c");
	List<String> strs3Test = Arrays.asList("");
	
	@Test
	public void noXTest() {
		assertEquals(strsTest, NoX .noX(strs));
		assertEquals(strs2Test, NoX .noX(strs2));
		assertEquals(strs3Test, NoX .noX(strs3));
	}
}
