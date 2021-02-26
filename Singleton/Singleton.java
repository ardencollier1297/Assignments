/**
 * 
 */
package com.arden;

/**
 * @author Arden
 * 
 * Program that implements Singleton with double checked locking
 *
 */
public class Singleton {

	//Day 4 Assignment 1
	
	// Make the constructor private so it can't be instantiated
	// from outside
	private Singleton() {
			
	}
		
	// Create an instance - make it volatile so that multiple threads
	// can handle the singleton correctly
	private volatile static Singleton instance;
	
	// Method for creating an instance
	public static Singleton getInstance() {
		synchronized (instance) {
			if(instance == null) {
				instance = new Singleton();
			}
		}
		
		return instance;
	}

}
