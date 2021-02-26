/**
 * 
 */
package com.arden.test;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.arden.Line;

/**
 * @author Arden
 *
 * Unit test file for Line.java using JUnit
 *
 */
public class LineTest {

	// Day 4 Assignment 4
	
	// Create two instances of the line class
	Line line = new Line(4.0, 20.0, 8.0, 20.0);
	Line lineTwo = new Line(8.0, 35.0, 5.0, 35.0);
	
	// Create test for the getSlope() method with 0 as expected
	// Per instructions, passed in .0001 as a delta
	@Test
	public void getSlopeTest( ) {
		assertEquals(0, line.getSlope(), .0001);
	}
	
	// Create test for the getDistance() method with 0 as expected
	// Per instructions, passed in .0001 as a delta
	@Test
	public void getDistanceTest() {
		assertEquals(4, line.getDistance(), .0001);
	}
	
	
	// Create test for the parallelTo() method, passed in the second line as
	// an argument - assertEquals does not accept a boolean arg so I used assertTrue()
	@Test
	public void parallelToTest() {
		assertTrue(line.parallelTo(lineTwo));
	}

}
