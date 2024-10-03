package ui;

import java.util.Scanner;

public class ScannerStuffApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Read an entire line...");
		
		String line = sc.nextLine();
		System.out.println(line);
		
		System.out.println("Read an int...");		
		int nbr1 = sc.nextInt();
		System.out.println(nbr1);
		
		System.out.println("Read a double...");		
		double dbl1 = sc.nextDouble();
		System.out.println(dbl1);
		
		System.out.println("Scan using next() on a long string..");
		System.out.println("Enter a song lyric: ");
		StringBuilder sb = new StringBuilder();
		String lyric = "She wore a ras";
		for (int i = 0; i <5; i++) {
			sb.append(sc.next());
		}
				
		System.out.println("sb= " + sb);
		
		
		
		System.out.println("Bye");
	}

}
