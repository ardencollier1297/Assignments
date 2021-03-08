package com.arden.utopia.menus;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.arden.utopia.entity.Booking;
import com.arden.utopia.entity.Passenger;

public class PassengerMenu {

	public static void init() {
		System.out.println("Would you like to:\n1) Add a passenger\n2) Delete a passenger\n3) View all passengers\n4) Return to main menu\n5) Quit");
		Scanner scan = new Scanner(System.in);
		try {
			int answer = scan.nextInt();
			switch(answer) {
			case 1:
				addPassenger();
				break;
			case 2:
				deletePassenger();
				break;
			case 3:
				viewAllPassengers();
				break;
			case 4:
				AdminMenu.init();
				System.exit(0);
				break;
			case 5:
				System.out.println("Logging you out. Have a good day!");
				System.exit(0);
				break;
			default:
				System.out.println("Sorry, your input was invalid!");
				init();
				break;
			}
		} catch (Exception e ) {
			System.out.println(e);
			init();
		} finally {
			scan.close();
		}
		
	}
	
	public static void addPassenger() throws ClassNotFoundException, SQLException {
		Passenger passenger = new Passenger();
		Scanner scan = new Scanner(System.in);
		Booking booking = new Booking();
		scan.useDelimiter("\n");
		try {
			Integer id = createConfirmationNumber();
			booking.setConfirmationCode(id);
			booking.setIsActive(1);
			booking.addBooking(booking);
			booking.getPrimaryId(booking);
			System.out.println("Please enter the passenger's first name:\r");
			String firstName = scan.next();
			System.out.println("Please enter the passenger's last name:\r");
			String lastName = scan.next();
			System.out.println("Please enter the passenger's date of birth (MM-DD-YYYY):\r");
			String dob = scan.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			LocalDate birthday = LocalDate.parse(dob, formatter);
			System.out.println("Please enter the passenger's gender:\r");
			String gender = scan.next();
			System.out.println("Please enter the passenger's address:\r");
			String address = scan.next();
			passenger.setAddress(address);
			passenger.setBookingId(booking.getId());
			passenger.setDob(birthday);
			passenger.setGivenName(firstName);
			passenger.setFamilyName(lastName);
			passenger.setGender(gender);
			passenger.addPassenger(passenger);
			passenger.getPrimaryId(passenger);
			System.out.println("Success! You have added the following passenger:");
			passenger.viewPassenger(passenger);
			init();
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong");
			addPassenger();
		} finally {
			scan.close();
		}
		
	}
	
	public static void deletePassenger() {
		Passenger passenger = new Passenger();
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Please enter the passenger's booking ID:");
			int id = scan.nextInt();
			passenger.setBookingId(id);
			passenger.viewPassenger(passenger);
			System.out.println("Are you sure you want to delete this passenger?\n");
			System.out.println("1) Yes\n2) No");
			int answer = scan.nextInt();
			switch(answer) {
				case 1:
					System.out.println("Passenger deleted");
					passenger.deletePassenger(passenger);
					break;
				case 2:
					init();
					break;
				default:
					System.out.println("Sorry, your input was invalid");
					deletePassenger();
					break;
			}
			init();
		} catch (Exception e) {
			System.out.println("Sorry, your input was invalid");
			deletePassenger();
		} finally {
			scan.close();
		}
		
	}
	
	public static void viewAllPassengers() throws ClassNotFoundException, SQLException {
		Passenger passenger = new Passenger();
		passenger.viewAllPassengers();
	}
	
	public static int createConfirmationNumber() {
		return (int) ((Math.random() * (50000 - 10000 + 1) + 10000)); 
	}
}
