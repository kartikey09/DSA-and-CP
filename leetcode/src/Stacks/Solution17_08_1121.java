package Stacks;

public class Solution17_08_1121 {
	class Solution {
	    public int trap(int[] arr) {
	        int n = arr.length;
	        int[] onRight = getGreatestOnRight(arr);
	        int[] onLeft = getGreatestOnLeft(arr);

	        int ans =0;
	        for(int i = 0; i < n; i++){
	            ans+= Math.max(0, Math.min(onRight[i], onLeft[i]) - arr[i]);
	        }

	        return ans;
	    }

	    int[] getGreatestOnLeft(int[] arr){
	        int n = arr.length;
	        int[] ans = new int[n];
	        int greatest = -1;

	        for(int i = 0; i < n; i++){
	            if(arr[i] > greatest){
	                greatest = arr[i];
	                ans[i] = -1;
	            } else {
	                ans[i] = greatest;
	            }
	        }
	        return ans;
	    }

	    int[] getGreatestOnRight(int[] arr){
	        int n = arr.length;
	        int[] ans = new int[n];
	        int greatest = -1;

	        for(int i = n-1; i >= 0; i--){
	            if(arr[i] > greatest){
	                greatest = arr[i];
	                ans[i] = -1;
	            } else {
	                ans[i] = greatest;
	            }
	        }
	        return ans;
	    }

	}
}


//https://leetcode.com/problems/trapping-rain-water/