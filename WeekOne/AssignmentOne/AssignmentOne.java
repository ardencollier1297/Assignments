package com.arden;


public class AssignmentOne {


	public static void main(String[] args) {
		// Day One Assignment One - Java
		String star = "*";
		
		firstPattern(star);
		secondPattern(star);
		thirdPattern(star);
		fourthPattern(star);
		}

		public static void firstPattern(String star) {
			
			StringBuffer stars = new StringBuffer(star);
			System.out.println("1)\n");
			for(int i = 0; i < 4; i++) {
				System.out.println(stars);
				stars.append(star);
				
			}
			StringBuffer dots = new StringBuffer("");
			for(int i = 0; i < 9; i++) {
				dots.append(".");
			}
			System.out.println(dots + "\n");
		}
		
		public static void secondPattern(String star) {

			StringBuffer stars = new StringBuffer(star);
			System.out.println("2)\n");
			for(int i = 0; i < 3; i++) {
				stars.append(star);
			}
			System.out.println(stars);
			for(int i = 0; i <= 2; i++) {
				stars.setLength(stars.length() -1);
				System.out.println(stars);
			}
			StringBuffer dots = new StringBuffer("");
			for(int i = 0; i < 10; i++) {
				dots.append(".");
			}
			System.out.println(dots + "\n");
		}
		
		public static void thirdPattern(String star) {
			
			StringBuffer stars = new StringBuffer("");
			System.out.println("3)\n");
			for(int i = 0; i < 5; i++) {
				stars.append(" ");
			}
			stars.append(star + "\n");
			for(int i = 0; i < 4; i++) {
				stars.append(" ");
			}
			for(int i = 0; i < 3; i++) {
				stars.append(star);
			}
			stars.append("\n");
			for(int i = 0; i < 3; i++) {
				stars.append(" ");
			}
			for(int i = 0; i < 5; i++) {
				stars.append(star);
			}
			stars.append("\n");
			for(int i = 0; i < 2; i++) {
				stars.append(" ");
			}
			for(int i = 0; i < 7; i++) {
				stars.append(star);
			}
			StringBuffer dots = new StringBuffer("");
			for (int i = 0; i < 11; i++) {
				dots.append(".");
			}
			System.out.println(stars);
			System.out.println(dots + "\n");
		}
		
		public static void fourthPattern(String star) {
			
			StringBuffer stars = new StringBuffer("");
			System.out.println("4)\n");
			StringBuffer dots = new StringBuffer("");
			for (int i = 0; i < 12; i++) {
				dots.append(".");
			}
			for(int i = 0; i < 2; i++) {
				stars.append(" ");
			}
			for(int i = 0; i < 7; i++) {
				stars.append(star);
			}
			stars.append("\n");
			for(int i = 0; i < 3; i++) {
				stars.append(" ");
			}
			for(int i = 0; i < 5; i++) {
				stars.append(star);
			}
			stars.append("\n");
			for(int i = 0; i < 4; i++) {
				stars.append(" ");
			}
			for(int i = 0; i < 3; i++) {
				stars.append(star);
			}
			stars.append("\n");
			for(int i = 0; i < 5; i++) {
				stars.append(" ");
			}
			stars.append(star);
			System.out.println(dots);
			System.out.println(stars);
		}

}
