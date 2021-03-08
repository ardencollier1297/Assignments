package com.arden.utopia.menus;

import java.util.Scanner;

public class AdminMenu {

	public static void init() {
		System.out.println("Welcome back! Please choose an option:\n1) Add/Change/Cancel/Check a Flight\n2) Add/Change/Cancel/Check a Seat\n3) Add/Change/Cancel/Check a Ticket\n4) Add/Change/Delete/Check an Airport\n5) Add/Change/Delete/Check a Traveler\n6) Add/Change/Delete/Check an Employee\n7) Over-ride a Trip Cancellation for a ticket\n8) Quit\r");
		Scanner scan = new Scanner(System.in);
		try {
			int answer = scan.nextInt();
			switch (answer) {
				case 1: 
					FlightMenu.init();
					break;
				case 2: 
					System.out.println("In progress");
					init();
					break;
				case 3: 
					TicketMenu.init();
					break;
				case 4: 
					AirportMenu.init();
					break;
				case 5: 
					PassengerMenu.init();
					break;
				case 6: 
					EmpMenu.init();
					break;
				case 7: 
					System.out.println("In progress");
					init();
					break;
				case 8:
					System.out.println("Logging you out. Have a great day!");
					System.exit(0);
				default:
					System.out.println("Sorry, that is not a valid answer");
					init();
			}
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong");
			init();
		} finally {
			scan.close();
		}
	}
}
