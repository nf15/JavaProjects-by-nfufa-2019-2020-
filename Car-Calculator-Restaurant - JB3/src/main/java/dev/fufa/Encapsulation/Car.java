package dev.fufa.Encapsulation;

public class Car {

	String make;
	String model;
	
	// private is an access modifier which means only your methods within this class
	// can access/see this variable
	private int mpg;
	
	// no argument constructor
	Car(){
		
		this.make = "Honda";
		this.model = "Civic";
		this.mpg = 35;
		
	}
	
	void showInfo() {
		System.out.println("Make : " + this.make + " Model : "+ this.model + " MPG : "+ this.mpg);
	}
	
	// I have encapsulated this variable  such that
	// there is no way assign mpg a value less than 0
	public void setMpg(int i) {
		
		if(i<0) {
			this.mpg = 0;
		}else {
			this.mpg = i;
		}
		
	}
	
	public int getMpg() {
		return this.mpg;
	}

}
