package dev.fufa.App;

public class Hero {
	
	//Created object instance (variables / class attributes)
	private String name;
	private int strength;
	private int health;
	
	//Defined object constructors and parameters for the Hero class
			Hero(String Name, int Strength, int Health) {    //parameters
				this.name = Name; 
				this.strength = Strength; 
				this.health = Health;			
		     }

			
	//set getters and setters for the hero(player) class

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public int getStrength() {
				return strength;
			}

			public void setStrength(int strength) {
				this.strength = strength;
			}

			public int getHealth() {
				return health;
			}

			public void setHealth(int health) {
				this.health = health;
			}

		}
		
			
			
	

