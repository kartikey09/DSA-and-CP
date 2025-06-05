package Recursion;

import java.util.ArrayList;

public class Solution04_06_0307 {

	public void printBinaryStrings(int pos, String ansSoFar, int n) {
		if(n == pos) {
			System.out.println(ansSoFar);
			return;
		}
		
		printBinaryStrings(pos+1, ansSoFar + "0", n);
		printBinaryStrings(pos+1, ansSoFar + "1", n);
	}


}
