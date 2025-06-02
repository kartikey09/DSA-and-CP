package Recursion;

public class Solution_02_06_0405 {
	public double myPow(double x, int n) {
        if(n == 1)
            return x;
        else if(n == 0)
            return 1;
        else if(n%2 == 0)
            return myPow(x*x, n/2);
        else if(n%2 == 1)  
            return x*myPow(x*x, n/2);
        return 1/myPow(x, n*-1);

    }
}

//https://leetcode.com/problems/powx-n/?source=submission-ac