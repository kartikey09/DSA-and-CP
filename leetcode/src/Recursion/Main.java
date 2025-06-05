package Recursion;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution04_06_0307 sol = new Solution04_06_0307();
		int n = sc.nextInt();
		sol.printBinaryStrings(0, "", n);
	}

}
