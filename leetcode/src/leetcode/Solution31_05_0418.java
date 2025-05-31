package leetcode;

public class Solution31_05_0418 {
	public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for(int x : nums) ans = Math.max(x, ans);
        int lmax = nums[0];
        int lmin = nums[0];
        for(int i = 0; i < nums.length; i++){
            int temp = lmax, n = nums[i];
            if(n == 0){ lmax = 1; lmin = 1; continue;}
            if(i == 0)   continue;
            lmax = Math.max(n,  Math.max(n*temp, n*lmin));
            lmin = Math.min(n,  Math.min(n*temp, n*lmin));
            ans = Math.max(ans, lmax);
        }
        return ans;
    }
}

//https://leetcode.com/problems/maximum-product-subarray/