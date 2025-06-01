package Binary_Search;

public class Solution01_06_0525 {
	 public int search(int[] nums, int target) {
	        int n = nums.length, l = 0, r = n-1;
	        while(l<=r){
	            int m = l + (r-l)/2;
	            if(target == nums[m])
	                return m;
	            if(nums[l] <= nums[m]){
	                if(nums[m] >= target && target >= nums[l])
	                    r = m-1;
	                else
	                    l = m+1;
	            } else {
	                if(nums[m] <= target && nums[r] >= target)
	                    l = m+1;
	                else
	                    r = m-1;
	            }
	        }
	        return -1;
	    }
}
