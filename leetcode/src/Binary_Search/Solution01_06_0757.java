package Binary_Search;

public class Solution01_06_0757 {
	public int searchInsert(int[] nums, int target) {
        int n = nums.length, l = 0, r = n-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(nums[m] <= target)
                l = m+1;
            else
                r = m-1;
        }
        if(r >= 0 && r <n && nums[r] == target)
            return r;
        return l;
    }
}

//https://leetcode.com/problems/search-insert-position/