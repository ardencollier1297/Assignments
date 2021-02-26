package com.arden;

public class Rectangle implements IShape {
	//Declare double for area
	private double area;
	
	@Override
	public void calculateArea(double width, double length) {
		this.area = width * length;
	}
	@Override
	public void display() {
		System.out.println(this.area);
	}
}