package Binary_Search;

public class Solution31_05_0514 {
	int lowerBound(int[] nums, int target) {
        int n = nums.length, l = 0, r = n-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(nums[m] >= target)
                r = m-1;
            else 
                l = m+1;
        }
        return l;
    }
}


//https://www.geeksforgeeks.org/problems/implement-lower-bound/1