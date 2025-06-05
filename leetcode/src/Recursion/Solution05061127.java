package Recursion;

import java.util.Arrays;

public class Solution05061127 {
	int mod = (int)1e9 + 7;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            if(x > (target+1)/2)
                break;
            
            int pos = binarySearch(target - x, nums);

            if(pos >= i)
                ans = (int)((ans + pow2(pos - i))%mod);
        }
        return ans;
    }

    long pow2(int n) {
        if(n == 0)
            return 1;
        long half = pow2(n / 2);
        if(n % 2 == 1)
            return (2 * half * half) % mod;
        return (half * half) % mod;
    }

    int binarySearch(int val, int[] nums){
        int n = nums.length, l = 0, r = n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid] <= val)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return r;
    }
}
//https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/