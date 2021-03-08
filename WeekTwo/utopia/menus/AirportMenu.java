package com.arden.utopia.menus;

import java.sql.SQLException;
import java.util.Scanner;

import com.arden.utopia.entity.Airport;

public class AirportMenu {
	
	
	public static void init() {
		System.out.println("Would you like to:\n1) Add an airport\n2) Change an airport\n3) Delete an airport\n4) View all airports\n5) Return to main menu\n6) Quit");
		Scanner scan = new Scanner(System.in);
		try {
			int answer = scan.nextInt();
			switch(answer) {
				case 1: 
					addAirport();
					break;
				case 2: 
					changeAirport();
					break;
				case 3: 
					deleteAirport();
					break;
				case 4: 
					viewAirports();
					break;
				case 5: 
					AdminMenu.init();
					break;
				case 6: 
					System.exit(0);
					break;
				default:
					System.out.println("Sorry, that was not a valid answer");
					init();
					break;
				}
		} catch (Exception e) {
			System.out.println("Sorry, that was not a valid answer");
			init();
		} finally {
			scan.close();
		}
		
	}
	
	public static void addAirport() throws ClassNotFoundException, SQLException {
		Airport airport = new Airport();
		System.out.println("Please enter the IATA code:");
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");
		try {
			String code = scan.next();
			airport.setCode(code);
			System.out.println("Please enter the city:");
			String city = scan.next();
			airport.setCity(city);
			airport.addAirport(airport);
			System.out.println("Success! You have added the airport " + airport.getCode() + " at " + airport.getCity());
			init();
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong");
		} finally {
			scan.close();
		}
		
	}
	
	public static void changeAirport() {
		Airport airport = new Airport();
		System.out.println("Which would you like to change:\n1) IATA code\n2) City");
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");
		try {
			int answer = scan.nextInt();
			switch(answer) {
			case 1:
				System.out.println("Please enter the city:\n");
				String city = scan.next();
				airport.setCity(city);
				System.out.println("Please enter the new IATA code:\n");
				String code = scan.next();
				airport.setCode(code);
				airport.editAirportCode(airport);
				System.out.println("Successfully changed the IATA code for " + airport.getCity() + " to " + airport.getCode());
				break;
			case 2:
				System.out.println("Please enter the IATA code:\n");
				code = scan.next();
				airport.setCode(code);
				System.out.println("Please enter the new city:\n");
				city = scan.next();
				airport.setCity(city);
				airport.editAirportCode(airport);
				System.out.println("Successfully changed the city for " + airport.getCode() + " to " + airport.getCity());
				break;
			default:
				System.out.println("Sorry, that was not a valid response");
				changeAirport();
				break;
			} 
			init();
		} catch (Exception e) {
			System.out.println("Sorry, that was not a valid response");
			changeAirport();
		} finally {
			scan.close();
		}
	}	
	
	public static void deleteAirport() throws ClassNotFoundException, SQLException {
		Airport airport = new Airport();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the IATA code of the airport you would like to delete:");
		String code = scan.next();
		airport.setCode(code);
		System.out.println("Are you sure you want to delete " + airport.getCode() + "?\n1) Yes\n2) No");
		try {
			int answer = scan.nextInt();
			switch(answer) {
				case 1:
					System.out.println(airport.getCode() + " has been deleted");
					airport.deleteAirport(airport);
					break;
				case 2:
					System.out.println(airport.getCode() + " has been deleted");
					airport.deleteAirport(airport);
					break;
				default:
					deleteAirport();
					break;
			}
			init();
		} catch (Exception e) {
			System.out.println("Sorry, your input was invalid");
			deleteAirport();
		} finally {
			scan.close();
		}
	}
	
	public static void viewAirports() throws ClassNotFoundException, SQLException {
		Airport airport = new Airport();
		airport.getAllAirports();
		init();
	}
}
