/**
 * 
 */
package com.arden;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Arden
 *
 * Program that uses a producer and consumer
 *
 */

public class ProducerConsumer {

	// Day 4 Assignment 3
	
	// Used BlockingQueue, which specifically waits for the queue to become non-empty
	// when retrieving, and waits for the queue to not be full before adding
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	

	public static void main(String[] args) throws InterruptedException {
		
		// Declare thread with producer
		Thread threadOne = new Thread(new Runnable() {
			public void run() {
				try {
					addNum();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		// Declare thread with consumer
		Thread threadTwo = new Thread(new Runnable() {
			public void run() {
				try {
					removeNum();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		// Start threads
		threadOne.start();
		threadTwo.start();
		
	}
	
	private static void addNum() throws InterruptedException {
		// Initialized random int to add to queue per instructions
		int randomInt; 
		
		while(true) {
			randomInt = (int) (Math.floor(Math.random() * 10) + 1);
			Thread.sleep(100);
			queue.put(randomInt);
			System.out.println(randomInt + " has been added to the queue");
		}
	}
	
	private static void removeNum() throws InterruptedException {
		while(true) {
			// Make thread sleep before taking from queue
			Thread.sleep(500);
			
			// Removes a value from the queue
			int value = queue.remove();
			System.out.println(value + " has been removed from the queue");
		}
	}
	
}
