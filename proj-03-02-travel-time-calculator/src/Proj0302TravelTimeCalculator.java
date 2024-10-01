import java.util.Scanner;

public class Proj0302TravelTimeCalculator {

	public static void main(String[] args) {
		System.out.println("Welcome to the Travel Time Calculator!");
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			System.out.print("Enter miles: ");
			double miles = sc.nextDouble();
			System.out.print("Enter miles per hour: ");
			double mph = sc.nextDouble();
			sc.nextLine();
			System.out.println("Estimated travel time");
			System.out.println("---------------------");
			// logic for hours / minutes
			int hours = (int)(miles / mph);
			double minutes = ((miles / mph) - hours) * 60;		
			int minuteRound = (int)minutes;
			
			// print hours and minutes
			System.out.printf("Hours: %d%n", hours);
			System.out.printf("Minutes: %d", minuteRound);
			
			System.out.print("\nContinue? (y/n): ");		
			choice = sc.nextLine();
		}
		System.out.println("Bye!");
	}

}
