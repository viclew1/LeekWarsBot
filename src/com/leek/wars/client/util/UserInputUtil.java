package com.leek.wars.client.util;

import java.util.Scanner;

public enum UserInputUtil {

	INSTANCE;


	private Scanner scanner;

	private UserInputUtil() {
		scanner = new Scanner(System.in);
	}

	/**
	 * Asks the user to enter a value
	 * @param varDisplayName
	 * @param needed
	 * @return Entered value
	 * @throws TechnicalException
	 */
	public String askValue(String varDisplayName, boolean needed) {
		System.out.println("Enter the " + varDisplayName + (needed ? "" : " (ENTER to skip)"));
		String input;
		while ((input = getNextLine()) == null && needed) {
			System.out.println("Invalid input.");
		}
		return input;
	}


	/**
	 * Asks the user to chose between multiple options.
	 * @param header line to display before the options
	 * @param quitOption if true, the user will be able to press q to quit
	 * @param options choices
	 * @return the index of the chosen option (first choice = 0; last choice = options.length - 1). 
	 * If options is empty, returns -1. 
	 * If user chooses to exit, returns -1
	 */
	public int askChoice(String header, boolean quitOption, Object... options) {

		if (options.length == 0) {
			return -1;
		}

		System.out.println(header);
		System.out.println("----------");
		for (int i = 1 ; i <= options.length ; i++) {
			System.out.println("  (" + i + ") " + options[i-1]);
		}
		System.out.println("----------");

		while (true) {
			System.out.println("Your choice ? " + (quitOption ? "(q to quit)" : ""));
			
			String choiceStr = UserInputUtil.INSTANCE.getNextLine();

			if (quitOption && choiceStr != null && "q".equalsIgnoreCase(choiceStr)) {
				return -1;
			}

			boolean ok = true;
			Integer choiceIndex = null;
			try {
				choiceIndex = Integer.parseInt(choiceStr) - 1;
			} catch (NumberFormatException e) {
				System.out.println("Invalid choice - Not a number");
				ok = false;
			}

			if (choiceIndex != null && (choiceIndex < 0 || choiceIndex >= options.length)) {
				System.out.println("Invalid choice - Not an option");
				ok = false;
			}

			if (ok) {
				return choiceIndex;
			}
		}

	}

	/**
	 * returns scanner.nextLine() but if the nextLine is empty, returns null instead of an empty String
	 */
	public String getNextLine() {
		String input = scanner.nextLine();
		if (input != null && input.isEmpty()) {
			input = null;
		}
		return input;
	}

}
