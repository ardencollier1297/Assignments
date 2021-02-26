/**
 * 
 */
package com.arden;

/**
 * @author Arden
 * 
 * Program that creates a deadlock between
 * two threads
 *
 */
public class CreateDeadlock {

	// Day 4 Assignment 2
	public static void main(String[] args) {

		// Declare two strings which will be used to cause the deadlock
		String lockOne = "I'm about to lock this!";
		String lockTwo = "And I'm going to cause a deadlock!";
		
		// Declare first thread as runnable
		Thread threadOne = new Thread(new Runnable() {
			
			// Cause first lock
			@Override
			public void run() {
				try {
					synchronized(lockOne) {
						Thread.sleep(1000);
						synchronized (lockTwo) {
							System.out.println("Thread 1 is running with 2 locks");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		// Declare second thread as runnable
		Thread threadTwo = new Thread(new Runnable() {
			
			// Cause second lock
			@Override
			public void run() {
				try {
					synchronized(lockTwo) {
						Thread.sleep(1000);
						synchronized (lockOne) {
							System.out.println("Thread 2 is running with 2 locks");
						}
					}
				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
			}
		});
		
		// Create threads for each runnable thread and start, causing deadlock
		threadOne.start();
		threadTwo.start();
	}

}
