import java.util.Scanner;

public class Proj0301TemperatureConverter {

	public static void main(String[] args) {
		System.out.println("Welcome to the Temperature Converter!");
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			System.out.print("Enter degrees in Fahernheit: ");
			double farh = sc.nextDouble();
			sc.nextLine();
			
			double cels = (farh-32) * 5/9;
			
			System.out.printf("Degree in Celsius: %.2f", cels);
			
			System.out.print("\nContinue? (y/n): ");		
			choice = sc.nextLine();
		}
		
		System.out.println("Bye!");
	}

}
