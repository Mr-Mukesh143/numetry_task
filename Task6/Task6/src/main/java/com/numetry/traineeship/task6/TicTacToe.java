package com.numetry.traineeship.task6;

import java.util.Scanner;

public class TicTacToe {

	static Scanner m = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("\t\t\tWELCOME TO TICTACTOE GAME!\n");
		System.out.println("TRY TO ENTER YOUR ANSWER IN ROW AND COLUMN WISE");
		char[][] board = new char[3][3];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}
		}
		char player = 'x';
		boolean gameOver = false;
		while (!gameOver) {
			try {

				printBoard(board);
				System.out.print("PLAYER " + player + " ENTER : ");
				int row = m.nextInt();
				int col = m.nextInt();
				if (board[row][col] == ' ') {
					board[row][col] = player;
					gameOver = won(board, player);
					if (gameOver)
						System.out.println("PLAYER " + player + " HAS WON");
					else
						player = (player == 'x') ? '0' : 'x';
				} else
					System.out.println("INVALID MOVE! TRY AGAIN");
			} catch (Exception e) {
				System.out.println("SOMETHING WENT WRONG TRY AGAIN");
				e.printStackTrace();
			}

		}
		printBoard(board);
	}

	public static boolean won(char[][] board, char player) {
		// check for row
		for (int row = 0; row < board.length; row++) {
			if (board[row][0] == player && board[row][1] == player && board[row][2] == player)
				return true;

		}
		// check for column
		for (int col = 0; col < board[0].length; col++) {
			if (board[0][col] == player && board[1][col] == player && board[2][col] == player)
				return true;

		}
		// check for diagonal
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		return false;
	}

	private static void printBoard(char[][] board) {

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + "|");
			}
			System.out.println();
		}
	}

}
