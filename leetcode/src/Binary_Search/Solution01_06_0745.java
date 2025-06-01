package Binary_Search;

public class Solution01_06_0745 {
	int upperBound(int[] nums, int target) {
        int n = nums.length, l = 0, r = n-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(nums[m] <= target)
                l = m+1;
            else
                r = m-1;
        }
        return l;
    }
}
