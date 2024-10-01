import java.util.Scanner;

public class Proj0304ChangeCalculator {

	public static void main(String[] args) {
		System.out.println("Welcome to the TChange Calculator!");
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			System.out.print("\nEnter number of cents (0-99): ");
			int enter = sc.nextInt();
			sc.nextLine();
			// logic for quarters25 / dimes10 / nickles5 / pennies1
			int q = enter / 25;
			int remainder = enter - (q*25);
			int d = remainder / 10;
			remainder = remainder - (d*10);
			int n = remainder / 5;
			remainder = remainder - (n*5);
			int p = remainder;
			
			// print quarters / dimes / nickles / pennies
			System.out.println();
			System.out.printf("%-10s %d%n", "Quarters:", q);
			System.out.printf("%-10s %d%n", "Dimes:", d);
			System.out.printf("%-10s %d%n", "Nickles:", n);
			System.out.printf("%-10s %d%n", "Pennies:", p);
			
			System.out.print("\nContinue? (y/n): ");		
			choice = sc.nextLine();
		}
		System.out.println("Bye!");
	}

}
