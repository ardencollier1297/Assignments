/**
 * 
 */
package com.arden;

/**
 * @author Arden
 * Program that creates three shapes, each implementing the 
 * shape interface, calculating the area and displaying the area
 */


public class ShapeInterface {
	// Day Two Assignment three - Create a shape interface and three classes
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		circle.calculateArea(6, 11);
		circle.display();
		
		rectangle.calculateArea(12, 14);
		rectangle.display();
		
		triangle.calculateArea(17, 9);
		triangle.display();
	}
	
	static Rectangle rectangle = new Rectangle();
	static Circle circle = new Circle();
	static Triangle triangle = new Triangle();

}
