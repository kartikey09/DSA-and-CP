package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution20_05_0710 {
	  public List<List<Integer>> threeSum(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> ans = new LinkedList<>();
	        if(nums.length < 3)
	            return Collections.emptyList();
	            int i = 0;
	            while( i < nums.length-2){
	                int j = i+1, k = nums.length-1;
	                while(j < k){
	                    int sum = nums[i] + nums[j] + nums[k];
	                    if(sum == 0){
	                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
	                        while(nums[j] == nums[++j] && j<k);
	                    } else if(sum < 0){
	                        while(nums[j] == nums[++j] && j<k);
	                    } else {
	                        while(nums[k] == nums[--k] && j<k);
	                    }
	                }
	                while(nums[i] == nums[++i] && i<nums.length-2);
	            }
	        return ans;
	    }
}


//https://leetcode.com/problems/3sum/