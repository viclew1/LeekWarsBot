package com.leek.wars.client.util;

import java.io.Console;

public enum UserInputUtil {

	INSTANCE;

	private final Console console;
	
	private UserInputUtil() {
		console = System.console();
	}

	/**
	 * Asks the user to enter a value
	 * @param varDisplayName
	 * @param needed
	 * @return Entered value
	 * @throws TechnicalException
	 */
	public String askString(String varDisplayName, boolean hidden, boolean needed) {
		System.out.println("Enter the " + varDisplayName + (needed ? "" : " (ENTER to skip)"));
		String input;
		while ((input = getNextLine(hidden)) == null && needed) {
			System.out.println("Invalid input.");
		}
		return input;
	}

	/**
	 * Asks the user to enter an integer value
	 * @param varDisplayName
	 * @param hidden
	 * @param needed
	 * @return
	 */
	public Integer askInteger(String varDisplayName, boolean hidden, boolean needed, Integer minValue, Integer maxValue) {
		
		System.out.println("Enter the " + varDisplayName + (needed ? "" : " (ENTER to skip)"));
		while (true) {
			String inputStr = getNextLine(hidden);
			if (!needed && inputStr == null) {
				return null;
			}
			if (inputStr == null) {
				System.out.println("Invalid value - Empty input");
				continue;
			}
			
			Integer val;
			try {
				val = Integer.parseInt(inputStr);
			} catch (NumberFormatException e) {
				System.out.println("Invalid value - Not a number");
				continue;
			}
			
			if (minValue != null && val < minValue) {
				System.out.println("Invalid value - Minimum value : " + minValue);
				continue;
			}
			if (maxValue != null && val > maxValue) {
				System.out.println("Invalid value - Maximum value : " + maxValue);
				continue;
			}
			
			return val;
		}
	}


	/**
	 * Asks the user to chose between multiple options.
	 * @param header line to display before the options (null if no header to display)
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

		if (header != null) {
			System.out.println(header);
		}

		System.out.println("----------");
		for (int i = 1 ; i <= options.length ; i++) {
			System.out.println("  (" + i + ") " + options[i-1]);
		}
		System.out.println("----------");

		while (true) {
			System.out.println("Your choice ? " + (quitOption ? "(q to quit)" : ""));

			String choiceStr = getNextLine(false);

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
	 * returns the next user input (and hides it if needed)
	 */
	private String getNextLine(boolean hidden) {
		return hidden ? new String(console.readPassword()) : console.readLine();
	}

}
