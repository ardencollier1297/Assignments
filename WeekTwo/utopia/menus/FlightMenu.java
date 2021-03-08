package com.arden.utopia.menus;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.arden.utopia.entity.Flight;
import com.arden.utopia.entity.Route;

public class FlightMenu {

	public static void init() {
		System.out.println("Would you like to:\n1) Add a flight\n2) Change an existing flight\n3) Cancel a flight\n4) View a flight\n5) View all flights\n6) Return to main menu\n7) Quit\r");
		Scanner scan = new Scanner(System.in);
		try {
			int answer = scan.nextInt();
			switch(answer) {
				case 1:
					addFlight();
					break;
				case 2:
					changeFlight();
					break;
				case 3:
					cancelFlight();
					break;
				case 4:
					viewFlight();
					break;
				case 5:
					viewAllFlights();
					break;
				case 6:
					AdminMenu.init();
					break;
				case 7:
					System.out.println("Logging you out. Have a great day!");
					System.exit(0);
					break;
				default:
					System.out.println("Sorry, that is not a valid answer");
					init();
					break;
			}
		} catch (Exception e) {
				System.out.println("Sorry, something went wrong");
				init();
		} finally {
			scan.close();
		}
	}
	
	public static void addFlight() throws ClassNotFoundException, SQLException {
		Flight flight = new Flight();
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");
		try {
			Route route = new Route();
			int flightId = createFlightNumber();
			flight.setId(flightId);
			System.out.println("Please enter the origin airport:");
			String origin = scan.next();
			try {
				Integer.parseInt(origin);
				System.out.println("Sorry, your input is invalid");
				addFlight();
			} catch(Exception e) {
				System.out.println("\r");
			}
			route.setOriginId(origin);
			System.out.println("Please enter the destination airport:");
			String destination = scan.next();
			try {
				Integer.parseInt(destination);
				System.out.println("Sorry, your input is invalid");
				addFlight();
			} catch(Exception e) {
				System.out.println("");
			}
			route.setDestId(destination);
			route.getPrimaryId(route);
			if(route.getId() == null) {
				route.addRoute(route);
				route.getPrimaryId(route);
			}
			flight.setRouteId(route.getId());
			System.out.println("Please enter the airplane ID:");
			int id = scan.nextInt();
			flight.setAirplaneId(id);
			System.out.println("Please enter the number of reserved seats:");
			int num = scan.nextInt();
			flight.setReservedSeats(num);
			System.out.println("Please enter the departure date and time (YYYY-MM-DD HH:MM:SS):");
			String departure = scan.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime departureTime = LocalDateTime.parse(departure, formatter);
			flight.setDeparture(departureTime);
			System.out.println("Please enter the ticket price:");
			float price = scan.nextFloat();
			flight.setSeatPrice(price);
			flight.addFlight(flight);
			System.out.println("Success! Flight Details:\nID: " + flight.getId() + "\nRoute ID: " + flight.getRouteId() + "\nAirplane ID: " + flight.getAirplaneId() + "\nSeat Price: " + flight.getSeatPrice() + "0\nDeparture: " + flight.getDeparture().format(formatter));
			init();
		} catch (Exception e){
			System.out.println("Sorry, your input was invalid");
			addFlight();
		} finally {
			scan.close();
		}
	}
	
	public static void changeFlight() throws ClassNotFoundException, SQLException {
		System.out.println("Please enter the Flight ID");
		Scanner scan = new Scanner(System.in);
		Integer flightId = scan.nextInt();
		Flight flight = new Flight();
		flight.setId(flightId);
		flight.viewFlight(flight);
		System.out.println("Please select what you would like to change:\n1) Origin airport\n2) Destination airport\n3) Return to previous menu\r");
		
		try {
			int answer = scan.nextInt();
			switch(answer) {
			case 1: 
				changeOrigin(flight);
				break;
			case 2: 
				changeDestination(flight);
				break;
			case 3:
				init();
				break;
			default: 
				changeFlight();
				break;
			}
			init();
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong");
			changeFlight();
		} finally {
			scan.close();
		}
		
	}
	
	public static void changeOrigin(Flight flight) throws ClassNotFoundException, SQLException {
		Route route = new Route();
		System.out.println("Please enter the new origin airport code:\r");
		Scanner scan = new Scanner(System.in);
		try {
			String answer = scan.next();
			route.setOriginId(answer);
			route.editOriginByPk(route, flight);
			System.out.println("Success! This flight is now");
			flight.viewFlight(flight);
			init();
		} catch (Exception e) {
			System.out.println("Sorry, that was not a valid airport code");
			changeOrigin(flight);
		} finally {
			scan.close();
		}
		
	}
	
	public static void changeDestination(Flight flight) throws ClassNotFoundException, SQLException {
		Route route = new Route();
		System.out.println("Please enter the new destination airport code:\r");
		Scanner scan = new Scanner(System.in);
		try {
			String answer = scan.next();
			route.setDestId(answer);
			route.editDestinationByPk(route, flight);
			System.out.println("Success! This flight is now");
			flight.viewFlight(flight);
			init();
		} catch (Exception e) {
			System.out.println("Sorry, that was not a valid airport code");
			changeDestination(flight);
		} finally {
			scan.close();
		}
		
	}
	
	public static void viewFlight() throws ClassNotFoundException, SQLException {
		Flight flight = new Flight();
		System.out.println("Please enter the flight ID:");
		Scanner scan = new Scanner(System.in);
		try {
			int answer = scan.nextInt();
			flight.setId(answer);
			flight.viewFlight(flight);
			System.out.println("View another flight?\n1) Yes\n2) No");
			answer = scan.nextInt();
			switch(answer) {
				case 1:
					viewFlight();
					break;
				case 2:
					AdminMenu.init();
					break;
				default:
					AdminMenu.init();
					break;
			}
		} catch (Exception e) {
			System.out.println("Sorry, your input was invalid");
			viewFlight();
		}
		
		scan.close();
	}
	
	public static void cancelFlight() throws ClassNotFoundException, SQLException {
		Flight flight = new Flight();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the flight number you would like to cancel: ");
		int answer = scan.nextInt();
		flight.setId(answer);
		System.out.println("Are you sure you want to cancel flight #" + flight.getId() + "?\n1) Yes\n2) No");
		answer = scan.nextInt();
		scan.close();
		switch(answer) {
			case 1: 
				System.out.println("Flight number " + flight.getId() + " has been cancelled");
				flight.cancelFlight(flight);
				break;
			case 2:
				init();
				break;
			default:
				init();
				break;
		}
	}
	
	public static void viewAllFlights() throws ClassNotFoundException, SQLException {
		Flight flight = new Flight();
		flight.viewAllFlights();
		init();
	}
	
	public static int createFlightNumber() {
		return (int) ((Math.random() * (50000 - 10000 + 1) + 10000));
	}
	
}
