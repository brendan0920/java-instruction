package ui;

import java.time.LocalDate;

import model.Person;
import util.Console;

public class ValueVsRefernceApp {

	public static void main(String[] args) {
		Console.printLine("Welcome to the value vs Reference types app");
		
		// value types
		int nbr1 = 5;
		double dbll = 2.7;
		boolean success = false;
		char char1 = 'a';
		char char2 = 127;
		
		Console.printLine("nbr1 = " + nbr1);
		addTwo(nbr1);
		Console.printLine("nbr1 addTwo = " + nbr1);
		int nbr2 = nbr1;
		nbr2 += 10;
		Console.printLine("nbr1: " + nbr1 + ", nbr2 = " + nbr2);
		
		
		// Reference type refers to the object in memory
		
//		Integer int1 = Integer.valueOf(7);
//		Console.printLine(int1.toString());
//		addTwo(int1);
//		Console.printLine(int1.toString());
		
		
		Person p1 = new Person("James", "Bond", LocalDate.of(1968, 5, 5), 'm');
		Console.printLine(p1.toString());
		Person p2 = p1;
		p1.setGender('f');
		Console.printLine(p2.toString());
		
		Console.printLine("Bye");
	}
	
	private static void addTwo(Integer n) {
		n = Integer.valueOf(n.intValue() + 2);		
	}
	
	private static void addTwo(int n) {
		n += 2;		
	}
	
	

}
