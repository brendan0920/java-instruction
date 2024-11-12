private static int getInt(String prompt) {
		boolean success = false;
		int nbr = 0;
		while (!success) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				nbr = sc.nextInt();
				success = true;
			} else {
				System.out.println("Invalid whole number");
			}
			sc.nextLine();
		}
		return nbr;
	}

	private static double getDouble(String prompt) {
		boolean success = false;
		double nbr = 0;
		while (!success) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				nbr = sc.nextDouble();
				success = true;
			} else {
				System.out.println("Invalid double number");
			}
			sc.nextLine();
		}
		return nbr;
	}
	
	// validate String entry against two acceptable values
	private static String getString(String prompt, String s1, String s2) {
		String str = "";
		boolean success = false;
		while (!success) {
			System.out.print(prompt);
			str = sc.nextLine();
			if (str.length() == 0) {
				System.out.println("Entry is required. Try again");
			} else if (!str.equalsIgnoreCase(s1) && !str.equalsIgnoreCase(s2)) {
				System.out.println("Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
			} else {
				success = true;
			}			
		}
		return str;
	}