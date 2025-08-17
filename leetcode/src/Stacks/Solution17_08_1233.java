package Stacks;

import java.util.Stack;

public class Solution17_08_1233 {
	class Solution {
	    int mod = (int)1e9 + 7;
	    public int sumSubarrayMins(int[] arr) {
	        int n = arr.length;
	        int[] dp = new int[n];
	        int[] nge = getNSE(arr);
	        int ans = 0;

	        for(int i = 0; i < n; i++){
	            if(nge[i] < 0){
	                dp[i] = (arr[i]*(i+1))%mod;
	            } else {
	                dp[i] = (dp[nge[i]] + (i - nge[i])*arr[i])%mod;
	            }
	            ans = (ans + dp[i])%mod;
	        }

	        return ans;
	    }

	    int[] getNSE(int[] arr){
	        int n = arr.length;
	        int[] ans = new int[n];
	        Stack<Integer> st = new Stack<>();
	        for(int i = 0; i < n; i++){
	            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
	            if(st.isEmpty())
	                ans[i] = -1;
	            else 
	                ans[i] = st.peek();
	            st.push(i);
	        }
	        return ans;
	    }
	}
}


//https://leetcode.com/problems/sum-of-subarray-minimums/