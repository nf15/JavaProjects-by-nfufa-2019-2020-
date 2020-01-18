package dev.fufa.Restaurant;

import java.util.List;

public class Calculator {

	
	double totalPrice(List<Meal> meals) {
		
		double total = 0.0;
		for(Meal meal : meals) {
			total = total + meal.price;
		}
		
		return total;
	}

	double tax(List<Meal> meals) {
		
		double total = totalPrice(meals);		
		double taxAmount = total * 0.03;
		
		return taxAmount;
		
	}
	
	
}

