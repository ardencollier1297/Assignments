package com.arden.utopia.menus;

import java.sql.SQLException;
import java.util.Scanner;
import com.arden.utopia.entity.Employee;

public class EmpMenu {
	
	public static void init() {
		System.out.println("Would you like to:\n1) Add an employee\n2) Delete an employee\n3) View all employees\n4) Return to main menu\n5) Quit");
		Scanner scan = new Scanner(System.in);
		try {
			int answer = scan.nextInt();
			switch(answer) {
			case 1:
				addEmployee();
				break;
			case 2:
				deleteEmployee();
				break;
			case 3:
				viewAllEmployees();
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
				System.out.println("Sorry, your input was invalid");
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
	
	public static void addEmployee() throws ClassNotFoundException, SQLException {
		Employee employee = new Employee();
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");
		try {
			System.out.println("Please enter the employee's first name:\r");
			String firstName = scan.next();
			System.out.println("Please enter the employee's last name:\r");
			String lastName = scan.next();
			System.out.println("Please enter the employee's email:\r");
			String email = scan.next();
			System.out.println("Please enter the employee's username:\r");
			String username = scan.next();
			System.out.println("Please enter the user's password:\r");
			String password = scan.next();
			System.out.println("Please enter the employee's phone number:\r");
			String phone = scan.next();
			System.out.println("Please select the employee's role:\n1) Admin\n2) Agent\n3) Sales");
			int choice = scan.nextInt();
			switch(choice) {
				case 1: 
					employee.setRoleId(10);
					break;
				case 2:
					employee.setRoleId(8);
					break;
				case 3:
					employee.setRoleId(9);
					break;
				default:
					System.out.println("Sorry, your input was invalid");
					addEmployee();
			}
			employee.setPassword(password);
			employee.setEmail(email);
			employee.setUsername(username);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setPhoneNumber(phone);
			employee.addEmployee(employee);
			employee.getPrimaryId(employee);
			System.out.println("Success! You have added the following employee:");
			employee.viewEmployee(employee);
			init();
		} catch (Exception e) {
			System.out.println(e);
			addEmployee();
		} finally {
			scan.close();
		}
		
	}
	
	public static void deleteEmployee() {
		Employee employee = new Employee();
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Please enter the employee's booking ID:");
			int id = scan.nextInt();
			employee.setId(id);
			employee.viewEmployee(employee);
			System.out.println("Are you sure you want to delete this employee?\n");
			System.out.println("1) Yes\n2) No");
			int answer = scan.nextInt();
			switch(answer) {
				case 1:
					employee.deleteEmployee(employee);
					break;
				case 2:
					init();
					break;
				default:
					System.out.println("Sorry, your input was invalid");
					deleteEmployee();
					break;
			}
			init();
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong");
			deleteEmployee();
		} finally {
			scan.close();
		}
		
	}
	
	public static void viewAllEmployees() throws ClassNotFoundException, SQLException {
		Employee employee = new Employee();
		employee.viewAllEmployees();
		init();
	}
}
