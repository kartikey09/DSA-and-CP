package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution20_05_0715 {
	 public List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> ans = new LinkedList<>();
	        Arrays.sort(nums);
	        int n = nums.length;
	        if(nums.length < 4)
	            return ans;
	        int l = 0 , r = n-1;
	        int i = l+1, j = r-1;
	        while(l < r-2){
	            // System.out.println(l + " " + r + " " + i + " " + j);
	            long sum = (long)nums[l] + (long)nums[r] + (long)nums[i] + (long)nums[j];
	            if(sum == (long)target){
	                ans.add(Arrays.asList(nums[l], nums[r], nums[i], nums[j]));
	                while(i < j && nums[j] == nums[--j]);
	            } else if(sum < target){
	                while(i < j && nums[i] == nums[++i]);
	            } else {
	                while(i < j && nums[j] == nums[--j]);
	            }
	            if(i >= j){
	                while(r > l+2 && nums[r] == nums[--r]);
	                i = l+1;
	                j = r-1;
	            }
	            if(l >= r-2){
	                while(l < n-1 && nums[l] == nums[++l]);
	                r = n-1;
	                i = l+1; 
	                j = r-1;
	            }                
	        }
	        return ans;
	    }
}

//https://leetcode.com/problems/4sum/description/