package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution21_05_0920 {
	ArrayList<Integer> findTwoElement(int nums[]) {
        int n = nums.length;
        int repeat = 0;
        
        for(int i = 0; i < n; i++){
            int k = Math.abs(nums[i]);
            if(nums[k-1] < 0)
                repeat = k;
            else
              nums[k-1] *= -1;
        }
        
        for(int i=0; i<n; i++){
            if(nums[i] > 0) return new ArrayList<Integer>(Arrays.asList(repeat, i+1));
        }
        return new ArrayList<Integer>();
    }
}

//https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1