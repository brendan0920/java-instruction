package ui;

import java.util.*;


import util.Console;

public class CountryListManager {
	 
	private static List<String> country;
	
	public static void main(String[] args) {
		country = new ArrayList<>();
		
		Console.printLine("Country Manager\n");
		
		// Display menu
		displayMenu();
		
		int command = 0;
		while (command != 3){
			command = Console.getInt("Enter menu number", 1, 3);
			switch(command) {
			case 1:
				// list countries
				listCountries();
				break;
			case 2:
				// add a country
				addCountry();
				break;
				
			case 3:
				break;				
			}			
		}		
		Console.printLine("Bye");
	}

	private static void displayMenu() {
		Console.printLine("COMMAND MENU");
		Console.printLine("1 - List countries");
		Console.printLine("2 - Add a country");
		Console.printLine("3 - Exit");
	}
	
	private static void listCountries() {
		Collections.sort(country, String.CASE_INSENSITIVE_ORDER);
		Console.printLine("\nList Countries");
		Console.printLine("==============");
		
		if (country.size() == 0) {
			Console.printLine("\nNo countries in the list.\n");
		} else {						
			for (int i = 0; i < country.size(); i++) {
			Console.printLine((i+1) +  "." + country.get(i));					
			}				
//			for (String countries: country) {
//				Console.printLine(countries);
//			}
		}
	}
	
	private static void addCountry() {
		Console.printLine("\nAdd a Country");
		Console.printLine("=============");
		String add = Console.getRequiredString("Enter country: ");
		if (country.contains(add)) {
			Console.printLine("This country is already in the list.");
			//continue;
		} else {
			country.add(add);
			Console.printLine("This country '" + add + "' has been added.");
		}
	}


}
