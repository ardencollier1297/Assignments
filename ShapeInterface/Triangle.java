package com.arden;

public class Triangle implements IShape {
	//Declare double for area
	private double area;
	
	@Override
	public void calculateArea(double length, double width) {
		this.area = (length * width)/2;
	}
	
	@Override
	public void display() {
		System.out.println(this.area);
	}
}
