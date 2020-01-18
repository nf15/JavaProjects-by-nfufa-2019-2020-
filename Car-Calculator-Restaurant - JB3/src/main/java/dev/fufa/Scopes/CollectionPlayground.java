package dev.fufa.Scopes;

import java.util.ArrayList;
import java.util.List;

public class CollectionPlayground {

	public static void main(String[] args) {
		
		Container container1 = new Container("John Smith", "rocks");
		Container container2 = new Container("John Goodall", "research supplies");
		Container container3 = new Container("The Grinch", "coal");
		
		// Arrays have a set size, you cannot store more than three containers in this array
		Container [] containers = new Container [3];
		containers[0] = container1;
		containers[1] = container2;
		containers[2] = container3;

		List<Container> containerlist = new ArrayList<Container>();
		containerlist.add(container1);
		containerlist.add(container2);
		containerlist.add(container3);
		containerlist.add(container1);
		containerlist.add(container2);
		containerlist.add(container3);
		
		containerlist.get(0).owner= "Janet";
		
		System.out.println(containerlist.get(4).owner);
	}

}
