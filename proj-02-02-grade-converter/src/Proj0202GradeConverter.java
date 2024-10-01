import java.util.Scanner;

public class Proj0202GradeConverter {

	public static void main(String[] args) {
		System.out.println("Welcometo the Grade Converter");
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {			
			System.out.print("\nEnter numerical grade: ");
			int grade = sc.nextInt();
			sc.nextLine();
			
			if (grade >= 88 && grade <= 100) {
				System.out.println("Letter Grade: A");
			} else if (grade >= 80 && grade <= 87) {
				System.out.println("Letter Grade: B");
			}else if (grade >= 67 && grade <= 87) {
				System.out.println("Letter Grade: C");
			}else if (grade >= 60 && grade <= 66) {
				System.out.println("Letter Grade: D");
			}else if (grade >= 0 && grade <= 59) {
				System.out.println("Letter Grade: F");
			}				
			System.out.print("Continue? (y/n): ");		
			choice = sc.nextLine();
		}
		
		System.out.println("\nBye!");
	}

}
