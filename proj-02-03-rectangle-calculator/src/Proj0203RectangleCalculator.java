import java.util.Scanner;

public class Proj0203RectangleCalculator {

	public static void main(String[] args) {
		System.out.println("\nWelcome to the Are and Permeter Calculator");
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			System.out.print("Enter length: ");
			double leng = sc.nextDouble();
			System.out.print("Enter width: ");
			double width = sc.nextDouble();
			sc.nextLine();
			
			// logic to calc area and perimeter
			double area = (leng * width);
			double perimeter = (2*(leng + width));
					
			// print area and perimeter
			System.out.println("Area: " + area);
			System.out.println("Perimeter: " + perimeter);
		
			System.out.print("\nContinue? (y/n): ");		
			choice = sc.nextLine();
			
		}
		
		System.out.println("\nBye");
	}

}
