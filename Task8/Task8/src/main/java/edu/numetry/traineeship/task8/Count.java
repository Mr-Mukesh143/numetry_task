package edu.numetry.traineeship.task8;

import java.util.Scanner;

public class Count {

	static Scanner m = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("COUNT OF THE NUMBERS & ALPHABETS & SYMBOLS");
		System.out.println("ENTER ANYTHING TO CHECK THE COUNT");
		String s = "Numetry@143";
		int a = 0, n = 0, sy = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z')
				a++;
			else if (c >= '0' && c <= '9')
				n++;
			else
				sy++;
		}
		System.out.println("COUNT OF THE NUMBERS : " + n);
		System.out.println("COUNT OF THE ALPHABETS : " + a);
		System.out.println("COUNT OF THE SYMBOLS : " + sy);
	}
}
