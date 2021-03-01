package com.arden;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arden
 *
 * Program that takes a string and returns the strings that begin with lowercase "a"
 * and are three letters long
 *
 */
public class AAndThreeLetters {

	// Day 5 Assignment 3
	
	// Method that returns a list of strings that begin with 'a' and 
	// are three letters long from filtering the first list
	public static List<String> aAndThree(List<String> strings) {
		return strings.stream().filter(s -> s.charAt(0) == 'a' && s.length() == 3).collect(Collectors.toList());
	}
}
