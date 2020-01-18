package dev.fufa.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
     
public class RestaurantPlayground {

	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		
		Meal [] menu = new Meal [4];
		
		Meal pasta = new Meal("Rigatoni", 12.25);
		Meal lobster = new Meal("Maine Lobster", 26.50);
		Meal stromboli = new Meal("Stromboli", 16.00);
		Meal pizza = new Meal("Pizza slice ", 3.00);
		
		menu[0] = pasta;
		menu[1] = lobster;
		menu[2] = stromboli;
		menu[3] = pizza;
		
		
		System.out.println("Welcome to Oliverio's");
		System.out.println("Please make a selection");
		
		System.out.println(pasta.getInfo() + " select 1");
		System.out.println(lobster.getInfo() + " select 2");
		System.out.println(stromboli.getInfo() + " select 3");
		System.out.println(pizza.getInfo() + " select 4");
		System.out.println("Press 5 to finish order");
		
		List<Meal> order = new ArrayList<Meal>();
		
		
		
		// for loops are good for knowing how many iterations you are going to be making
		boolean isordering = true;
			
		while(isordering) {
			
			int selection = scan.nextInt();
			switch(selection) {
			
			case 1 : order.add(pasta); break;
			case 2 : order.add(lobster); break;
			case 3 : order.add(stromboli); break;
			case 4 : order.add(pizza); break;
			case 5 : isordering = false; break;
						
			}
		
		}
		
		for(Meal meal : order) {
			meal.showInfo();
		}

		
		Calculator calc = new Calculator();
		double subtotal = calc.totalPrice (order);
		double taxAmount = calc.tax(order);
		System.out.println("Subtotal : " + subtotal);
		System.out.println("Tax : " + taxAmount);
		System.out.println("Total : " + (subtotal + taxAmount) );
		
	}

}


	