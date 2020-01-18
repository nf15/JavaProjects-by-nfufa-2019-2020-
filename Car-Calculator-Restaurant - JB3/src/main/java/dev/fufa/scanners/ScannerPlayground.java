package dev.fufa.scanners;

import java.util.Scanner;

public class ScannerPlayground {
public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome! What is your name?");
		String name = scan.nextLine(); // next line gives you back a string;		
		System.out.println("Hello " + name);
		
		System.out.println("Give me a number to multiply by 10");
		int input = scan.nextInt();
		int product = input *10;
		
		System.out.println(product);
		
		// you should close the scanner as your last line of code
		scan.close();
	}
	
	
	
	
	
	

}

