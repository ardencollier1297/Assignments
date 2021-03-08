/**
 * 
 */
package com.arden.utopia.route;

import java.sql.SQLException;
import java.util.Scanner;

import com.arden.utopia.entity.Route;
import com.arden.utopia.menus.AdminMenu;

/**
 * @author Arden
 *
 */
public class UtopiaMain {
	static Route route = new Route();
	
	
	public static void main(String[] args) {
		try {
			System.out.println("Welcome to Utopia Airlines Management System.");
			init();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void init() throws SQLException, ClassNotFoundException {
		System.out.println("Which category of a user are you?\n1) Employee\n2) Administrator\n3) Traveler\r");
		Scanner scan = new Scanner(System.in);
		try {
			int answer = scan.nextInt();
			switch(answer) {
				case 1:
					System.out.println("Sorry, still in progress!");
					init();
					break;
				case 2:
					AdminMenu.init();
					break;
				case 3:
					System.out.println("Sorry, still in progress!");
					init();
					break;
				default:
					System.out.println("Sorry, that is not a valid answer");
					init();
					break;
			}
		} catch (Exception e) {
			System.out.println("Sorry, that is not a valid option. Please try again.");
			init();
		} finally {
			scan.close();
		}
		
		
	}

}
