package edu.numetry.traineeship.task2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	public NumberGuessingGame() {

	}

	static Random random = new Random();
	static int minNum = 1, maxNum = 100, randomNumber = random.nextInt();
	static int rewards = 100, count = 0, playerGuess;
	static boolean guessed = false;
	static Scanner m = new Scanner(System.in);

	public static void main(String[] args) {

		do {
			System.out.println("\t\t\tWELCOME TO THE NUMBER GUESSING GAME!\n\n");
			System.out.println("WHICH LEVEL YOU WANT TO PLAY");
			System.out.println("1.EASY\n2.MEDIUM\n3.HARD");

			try {
				switch (m.nextInt()) {
				case 1:
					randomNumber = random.nextInt(100);
					new Easy().game();
					break;
				case 2:
					maxNum = 500;
					randomNumber = random.nextInt(500);
					new Medium().game();
					break;
				case 3:
					maxNum = 1000;
					randomNumber = random.nextInt(1000);
					new Hard().game();
					break;
				default:
					System.out.println("ENTER A VALID NUMBER");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("SOMETHING WENT WRONG");
				guessed = true;
			}
		} while (guessed != true);
	}

	public void game() {
		System.out.println("\t\t\tWELCOME TO THE NUMBER GUESSING GAME!\n\n");
		System.out.println("WE HAVE A RANDOM NUMBER FROM " + this.minNum + " TO " + this.maxNum
				+ " TRY TO GUESS THE CORRECT NUMBER");
		System.out.println("NOW YOUR REWARD POINT IS " + rewards);
		try {
			while (guessed != true) {
				if (rewards > 0) {
					System.out.println("ENTER YOUR GUESSING NUMBER");
					playerGuess = m.nextInt();
					count++;
					if (playerGuess == randomNumber) {
						System.out.println("\t\t\tCONGRATULATIONS! YOUR ARE GUESSED THE CORRECT NUMBER " + randomNumber
								+ " IN " + count + " GUESSES");
						System.out.println("\n\nFINALLY YOU GOT THE REWARD POINTS " + rewards);
						guessed = true;
					} else if (playerGuess < minNum || playerGuess > maxNum) {
						rewards -= 10;
						System.out.println("PLEASE ENTER A NUMBER BETWEEN " + minNum + " AND " + maxNum);
						System.out.println("YOUR REWARD POINT IS " + rewards);
					} else if (playerGuess < randomNumber) {
						rewards -= 10;
						System.out.println("TOO LOW! TRY AGAIN");
						System.out.println("YOUR REWARD POINT IS " + rewards);
					} else if (playerGuess > randomNumber) {
						rewards -= 10;
						System.out.println("TOO HIGH! TRY AGAIN");
						System.out.println("YOUR REWARD POINT IS " + rewards);
					}
				} else {
					System.out.println("\n\t\t\tGAME OVER!");
					guessed = true;
				}
			}
		} catch (Exception e) {
			System.out.println("INVALID DATA ENTERED " + playerGuess);
		}
		m.close();
	}
}

class Easy extends NumberGuessingGame {

}

class Medium extends NumberGuessingGame {

}

class Hard extends NumberGuessingGame {

}
