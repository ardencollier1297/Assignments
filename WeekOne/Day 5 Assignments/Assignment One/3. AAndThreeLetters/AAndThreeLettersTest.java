package com.arden.test;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.arden.AAndThreeLetters;

/**
 * @author Arden
 *
 * Unit testing for AAndThreeLetters program
 *
 */
public class AAndThreeLettersTest {
	
	List<String> strs = Arrays.asList("apple", "bee", "add", "substract", "ate", "Ape");
	List<String> strs2 = Arrays.asList("grape", "apricot", "all", "Act", "elbow", "cat", "aim");
	List <String> strsTest = Arrays.asList("add", "ate");
	List<String> strs2Test = Arrays.asList("all", "aim");
	
	@Test
	public void aAndThreeLettersTest() {
		assertEquals(strsTest, AAndThreeLetters.aAndThree(strs));
		assertEquals(strs2Test, AAndThreeLetters.aAndThree(strs2));
	}
}
