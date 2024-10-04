package ui;

import java.util.ArrayList;
import java.util.List;

import util.Console;

public class CountryListManager {

	 
	
	public static void main(String[] args) {
		List<String> country = new ArrayList<>();
		
		Console.printLine("Country Manager\n");
		
		// Display menu
		Console.printLine("COMMAND MENU");
		Console.printLine("1 - List countries");
		Console.printLine("2 - Add a country");
		Console.printLine("3 - Exit");
		
		int command = 0;
		while (command != 3){
			command = Console.getInt("Enter menu number");
			switch(command) {
			case 1:
				// list countries
					if (country.size() == 0) {
						Console.printLine("No countries in the list.");
					} else {						
						for (int i = 0; i < country.size(); i++) {
						Console.printLine((i+1) +  "." + country.get(i));					
						}				
					}
				break;
			case 2:
				// add a country
				String add = Console.getRequiredString("Enter country: ");
				if (country.contains(add)) {
					Console.printLine("This country is already in the list.");
					continue;
				} else {
					country.add(add);
					Console.printLine("This country '" + add + "' has been added.");
				}
				break;
				
			case 3:
				break;
				
			}
			
		}
		
		Console.printLine("Bye");
	}

}
