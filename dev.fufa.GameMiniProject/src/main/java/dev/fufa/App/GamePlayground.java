package dev.fufa.App;

import java.util.Scanner;

 public class GamePlayground {
	
 public static Scanner scan = new Scanner(System.in);
  
 public static void main(String[] args) {  
	 
      Hero heroInput = new Hero ("Name", 60, 800);  //input parameters
      Enemy opponentInput = new Enemy("Name", 40, 400);
	
	System.out.println("Type your Name and press Enter: ");
	heroInput.setName(scan.nextLine());

	System.out.println(heroInput.getName() + ", Welcome to Best Hero Game!");
		
	System.out.println("What is your Health? ");
	heroInput.setHealth(scan.nextInt());
		 	
	System.out.println("What is opponent's Strength? ");
	opponentInput.setStrength(scan.nextInt());
	scan.nextLine();	
		
	System.out.println("Ready for Battle? Press Enter:");
    scan.nextLine();  
  		
    
     while(heroInput.getHealth() > 0) {       
		   
		 heroInput.setHealth(heroInput.getHealth() - opponentInput.getStrength());
		 System.out.println(heroInput.getHealth());

	  if(heroInput.getHealth() - opponentInput.getStrength() > 0)  {
	     System.out.println("Hooray! You are the winner!");
        
         } else { 
               System.out.println("hummm:( You lost the battle!");
               System.out.println("The Game is over!!!");
        
        break;
      
       }
    
      }
   
	}
 
}
 
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
     /// created Parameters in main method for Strength and Health, but fail to run ///
//Hero heroInput = new Hero("Name", Strength, Health); 
 //Enemy opponentInput = new Enemy("Name", Strength, Health); 

