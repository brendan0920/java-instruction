import java.text.NumberFormat;
import java.util.Scanner;

public class Proj0303InterestCalculator {

	public static void main(String[] args) {
		System.out.println("Welcome to the Interest Calculator!");
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			System.out.printf("%-22s", "Enter loan amount: ");
			double loan = sc.nextDouble();
			System.out.printf("%-22s", "Enter interest rate: ");
			double rate = sc.nextDouble();
			sc.nextLine();

			// logic for 
			// loan amount 
			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
			String loanAmt = currencyFormatter.format(loan);			
			// interest rate 
			NumberFormat pctFormatter = NumberFormat.getPercentInstance();
			pctFormatter.setMaximumFractionDigits(3);
			String interestRate = pctFormatter.format(rate);			
			// interest amount
			double calculateAmt  = loan * rate;			
			String interestAmt = currencyFormatter.format(calculateAmt);			
			
			// print loan amount / interest rate / interest amount			
			System.out.printf("%-21s %s%n", "Loan amount:", loanAmt);						
			System.out.printf("%-21s %s%n", "Interest rate:", interestRate);			
			System.out.printf("%-21s %s%n", "Interest:", interestAmt);
			
			System.out.print("\nContinue? (y/n): ");		
			choice = sc.nextLine();
		}
		System.out.println("Bye!");
	}

}
