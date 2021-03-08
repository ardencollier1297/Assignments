package com.arden.utopia.menus;

import java.util.Scanner;

import com.arden.utopia.entity.Route;

public class RouteMenu extends Route {

	public static void init() {
		System.out.println("Would you like to:\n1) Add a route\n2) Change a route\n3) Delete a route\n4) View a route");
		Scanner scan = new Scanner(System.in);
		int answer = scan.nextInt();
		try {
			switch(answer) {
			 case 1: 
				 addRoute();
				 break;
			 case 2: 
				 System.out.println("in progress");
				 break;
			 case 3: 
				 System.out.println("in progress");
				 break;
			 case 4: 
				 System.out.println("in progress");
				 break;
			default:
				System.out.println("Sorry, that is not a valid answer");
				init();
				break;
			}
		} catch (Exception e) {
			System.out.println("Sorry, that is not a valid answer");
			init();
		} finally {
			scan.close();
		}
		
	}
	
	public static void addRoute() {
		try {
			Route route = new Route();
			Scanner scan = new Scanner(System.in);
			System.out.println("What is the origin ID?");
			String answer = scan.next();
			route.setOriginId(answer);
			System.out.println("What is the destination ID?");
			answer = scan.next();
			route.setDestId(answer);
			route.addRoute(route);
			System.out.println(route.getId());
			System.out.println("Success! New route: " + route.getOriginId() + "->" + route.getDestId());
			scan.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
