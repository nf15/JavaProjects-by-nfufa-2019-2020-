package dev.fufa.Scopes;

public class ScopePlayground {

public static void main(String [] args) {
		
		// I am using a static method without ever having created a container
		Container.desribeContainer();
	}
	
	
	 static void sayHello() {
		 
		 // greeting here is a block scope variable
		 // There is no way to access this variable outside of this block
		String greeting = "Hello everyone";
		
		System.out.println(greeting);
	 }
	 
	 static void scopeExample() {
		 
		 // int x is in a block scope CURLY BRACKETS!!!
		 
		 {
		 int x = 100;
		 
		 	{ // this works because x and the method that uses it are still 
		 	 // in the same outer brackets
			 System.out.println(x);
		 	}
		 
		 	System.out.println(x);
		 }
		 
		 // this method cannot grab x beacuse x is in a different block scope
		// System.out.println(x);
		 
	 }
	 
	 static void methodScope(int y) {
		 // y is method scoped
		 // method scope is variables that are the parameters to a method
		 // y is accesible anywhere in this method regardless of any curly brackets
		 
		 //crazy scoping
		 {
			 {
				 {
					 {
						 y = 30;
					 }
					 {
						 
					 }
				 }
				 {
					 y =30;
				 }
			 }
			 {
				 y=20;
			 }
		 }
		 
		 
	 }
	
}
