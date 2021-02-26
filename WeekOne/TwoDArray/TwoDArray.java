/**
 * 
 */
package com.arden;

/**
 * @author Arden
 * Program that returns the max number in a 2D array as 
 * well as its position
 */
public class TwoDArray {
	// Day Two Assignment Two - Create a 2D array, return its max and the position of the max
	public static void main(String[] args) {
		
		int[][] twoDArr = {{11, 24, 6}, {38, 101, -4}};
		
		int max = twoDArr[0][0];
		int iMax = 0;
		int jMax = 0;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if(twoDArr[i][j] > max) {
					max = twoDArr[i][j];
					iMax = i;
					jMax = j;
				}
			}
		}
		System.out.println("Max is " + max + ", and its position is [" + iMax + "][" + jMax + "]" );
 	}

}
