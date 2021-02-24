package com.arden;

public class Circle implements IShape {
	//Declare double for area
	private double area;
	
	@Override
	public void calculateArea(double length, double width) {
		this.area = Math.pow((double) ((length / 2) * 3.14), 2);
	}
	@Override
	public void display() {
		System.out.println(area);
	}
}
