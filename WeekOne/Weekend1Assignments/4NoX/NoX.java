package com.arden;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arden
 *
 * Program that takes a list of strings, removes any "x"s and returns a new list
 *
 */
public class NoX {
	
	// Weekend 1 Assignment 4
	public static List<String> noX(List<String> strings) {
		return strings.stream().map(s -> s.replace("x", "")).collect(Collectors.toList());
	}
}
