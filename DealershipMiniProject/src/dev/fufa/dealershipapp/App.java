package dev.fufa.dealershipapp;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Map;
	import java.util.Scanner;
	import java.util.Set;

	public class App {

		public static void main( String []  args) {
			Scanner scan = new Scanner(System.in);
			
			// making objects for us to work with
			Salesman jim = new Salesman("jimmyfallon", "James Smith", 0,0);
			Salesman anna = new Salesman("annie", "Annette Jones", 0,0);
			
			Car prius = new Car("Toyota", "Prius", 2015,50000,14000);
			Car lexus = new Car("Lexus", "Eclipse", 2019, 90000, 0);
			
			List<Car> cars = new ArrayList<Car>();
			cars.add(lexus);
			cars.add(prius);
			
			Map<String, Salesman> sales = new HashMap<String,Salesman>();
			sales.put(jim.getUsername(), jim);
			sales.put(anna.getUsername(), anna);
			
			// prompting user to log in
			System.out.println("Welcomes to Honest Abe's Honest cars of Honesty");
			System.out.println("Please login using your username");
			String username = scan.nextLine();
			
			Salesman user = sales.get(username);
			
			user.printStats();
			
			while(true) {	
			System.out.println("Please pick a car to sell");
			
			for(Car c : cars) {
				c.showStats();
			}
			
			int choice = scan.nextInt();
			Car car = cars.get(choice);
			user.sellCar(car);
			cars.remove(choice);
			user.printStats();
			}
			
			
		}
		
		
	}

