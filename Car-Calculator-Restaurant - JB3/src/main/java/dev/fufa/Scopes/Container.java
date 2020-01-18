package dev.fufa.Scopes;

public class Container {
	
	// instatnce variables
		// each object of this class gets an owner and content variable
		String owner;
		String content;
		
		// highest scope which means that the variable is shared by all containers
		// Variable is not attached to an object, but to the class
		static int totalcontainers = 0;
		
		// Because static means that this does not belong to any particular object
		// you can use a static variable or method without using an object
		static void desribeContainer() {
			System.out.println("A container is something that can store things");
		}
		
		Container(String owner, String content){
			
			this.owner = owner;
			this.content = content;
			totalcontainers++;
		}

		void describeMyself() {
			System.out.println("Owner : " +this.owner + " content : " +this.content);
		}
		
		
		
		
	}
