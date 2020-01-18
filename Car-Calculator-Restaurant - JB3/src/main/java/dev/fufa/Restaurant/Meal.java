package dev.fufa.Restaurant;

public class Meal {

	String name;
	double price;
	
	Meal(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	void showInfo() {
		System.out.println("Name : " + this.name + " Price : "+ this.price);		
	}
	
	 String getInfo() {
		return "Name : " + this.name + " Price : "+ this.price ;
	}

}
