package Binary_Search;

public class Solution01_06_0837 {
	public int[] searchRange(int[] nums, int target) {
        int n = nums.length, l = 0, r = n-1, ans1, ans2;
        while(l <= r){
            int m = l + (r-l)/2;
            if(nums[m] >=  target)
                r = m-1;
            else
                l = m+1;
        }
        ans1 = (l>=0 && l< n && nums[l] == target ? l : -1);
        l = 0; r = n-1;

        while(l <= r){
            int m = l + (r-l)/2;
            if(nums[m] <=  target)
                l = m+1;
            else
                r = m-1;
        }
        ans2 = (r>=0 && r < n && nums[r] == target ? r : -1);

        return new int[] {ans1, ans2};
    }
}

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/