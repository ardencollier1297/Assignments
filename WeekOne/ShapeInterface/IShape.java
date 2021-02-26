package com.arden;

// Declare the Shape interface as well as declaring the abstract methods each class will need
public interface IShape {
	abstract void calculateArea(double length, double width);
	void display();
}