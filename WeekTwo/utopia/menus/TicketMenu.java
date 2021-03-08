package com.arden.utopia.menus;

import java.sql.SQLException;
import java.util.Scanner;

import com.arden.utopia.entity.Ticket;

public class TicketMenu {
	
	public static void init() {
		System.out.println("Would you like to:\n1) Create a new ticket\n2) Cancel a ticket\n3) View a ticket\n4) Change a seat\n5) View all tickets\n6) Return to main menu\n7) Quit");
		Scanner scan = new Scanner(System.in);
		try {
			int answer = scan.nextInt();
			switch(answer) {
				case 1:
					addTicket();
					break;
				case 2:
					cancelTicket();
					break;
				case 3:
					viewTicket();
					break;
				case 4:
					changeSeat();
					break;
				case 5:
					viewAllTickets();
					break;
				case 6:
					AdminMenu.init();
					break;
				case 7:
					System.out.println("Logging you out. Have a great day!");
					System.exit(0);
					break;
				default:
					System.out.println("Sorry, your input was invalid");
					init();
					break;
			}
		} catch (Exception e) {
			System.out.println(e);
			init();
		} finally {
			scan.close();
		}
	}
		
	
	public static void addTicket() throws ClassNotFoundException, SQLException {
		Ticket ticket = new Ticket();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the flight ID:");
		try {
			int answer = scan.nextInt();
			ticket.setFlightId(answer);
			ticket.checkForFlight(ticket);
			System.out.println("Please enter the passenger ID:");
			answer = scan.nextInt();
			ticket.setPassengerId(answer);
			ticket.checkForPassenger(ticket);
			System.out.println("Please choose the seat type:\n1) First class\n2) Business\n3) Economy");
			int choice = scan.nextInt();
			switch (choice) {
				case 1:
					ticket.setSeatType("First class");
					break;
				case 2:
					ticket.setSeatType("Business");
					break;
				case 3:
					ticket.setSeatType("Economy");
					break;
				default:
					System.out.println("Sorry, your input was invalid");
					addTicket();
					break;
			}
			ticket.addTicket(ticket);
			ticket.getPrimaryId(ticket);
			System.out.println("Success! You have successfully created the following ticket:");
			ticket.viewTicket(ticket);
			init();
		} catch (Exception e) {
			System.out.println(e);
			addTicket();
		} finally {
			scan.close();
		}
	}
	
	public static void cancelTicket() throws ClassNotFoundException, SQLException {
		Ticket ticket = new Ticket();
		System.out.println("Please enter the Ticket ID: ");
		Scanner scan = new Scanner(System.in);
		try {
			int id = scan.nextInt();
			ticket.setId(id);
			ticket.viewTicket(ticket);
			System.out.println("Are you sure you want to delete this ticket?\n1) Yes\n2) No");
			int answer = scan.nextInt();
			switch(answer) {
				case 1:
					ticket.deleteTicket(ticket);
					break;
				case 2: 
					init();
					break;
				default:
					System.out.println("Sorry, your input was invalid");
					cancelTicket();
					break;
			}
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong");
			cancelTicket();
		} finally {
			scan.close();
		}
	}
	
	public static void viewTicket() {
		Ticket ticket = new Ticket();
		System.out.println("Please enter the Ticket ID: ");
		Scanner scan = new Scanner(System.in);
		try {
			int id = scan.nextInt();
			ticket.setId(id);
			ticket.viewTicket(ticket);
			init();
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong");
			viewTicket();
		} finally {
			scan.close();
		}
	}
		
	public static void changeSeat() {
		Ticket ticket = new Ticket();
		System.out.println("Please enter the Ticket ID: ");
		Scanner scan = new Scanner(System.in);
		try {
			int id = scan.nextInt();
			ticket.setId(id);
			ticket.viewTicket(ticket);
			System.out.println("What is the new seat type?\n1) First class\n2) Business\n3) Economy\n4) Cancel");
			int answer = scan.nextInt();
			switch (answer) {
			case 1:
				ticket.setSeatType("First class");
				ticket.changeSeat(ticket);
				System.out.println("Success! Ticket " + ticket.getId() + " is now:" );
				ticket.viewTicket(ticket);
				init();
				break;
			case 2:
				ticket.setSeatType("Business");
				ticket.changeSeat(ticket);
				System.out.println("Success! Ticket " + ticket.getId() + " is now:" );
				ticket.viewTicket(ticket);
				init();
				break;
			case 3:
				ticket.setSeatType("Economy");
				ticket.changeSeat(ticket);
				System.out.println("Success! Ticket " + ticket.getId() + " is now:" );
				init();
				ticket.viewTicket(ticket);
				break;
			case 4:
				init();
				break;
			default:
				System.out.println("Sorry, your input was invalid");
				changeSeat();
				break;
			}
		} catch (Exception e) {
			System.out.println(e);
			viewTicket();
		} finally {
			scan.close();
		}
	}
	
	public static void viewAllTickets() throws ClassNotFoundException, SQLException {
		Ticket ticket = new Ticket();
		ticket.viewAllTickets();
		init();
	}
}
