package Recursion;

public class Solution04_06__248 {
	int mod = (int)1e9+7;
    public int countGoodNumbers(long n) {
        if(n == 1) return 5;
        if(n%2 == 0)
            return (int)((getPow(20, n/2))%mod);
        else 
            return (int)(((getPow(20, n/2)%mod) * 5)%mod);
    }
    long getPow(long x, long n){
        if(n == 0) return 1;

        if(n%2 == 0)
            return getPow((x*x) % mod, n/2)%mod;
        else 
            return (x*getPow((x*x) % mod, n/2))%mod;
    }

}

//https://leetcode.com/problems/count-good-numbers/