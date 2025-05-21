package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

class Solution21_05_0108 {
	 public int[][] merge(int[][] nums) {
	        Arrays.sort(nums, (a,b)-> a[0] - b[0]);
	        ArrayList<int[]> ans = new ArrayList<>();

	        int[] ar = new int[2];
	        ar[0] = nums[0][0];
	        ar[1] = nums[0][1];
	        ans.add(ar);

	        for(int i = 1; i < nums.length; i++){
	            int l = ans.size()-1;
	            if(ans.get(l)[0] == nums[i][0]){
	                ans.get(l)[1] = Math.max(ans.get(l)[1], nums[i][1]);
	            } else if(ans.get(l)[1] >= nums[i][0]){   
	                ans.get(l)[1] = Math.max(ans.get(l)[1], nums[i][1]); 
	            } else {
	                int[] ar2 = new int[]{nums[i][0], nums[i][1]};
	                ans.add(ar2);
	            }
	        }

	        int[][] ans2 = new int[ans.size()][2];
	        for(int i = 0; i < ans2.length; i++){
	            ans2[i][0] = ans.get(i)[0];
	            ans2[i][1] = ans.get(i)[1];
	        }
	        return ans2;
	    }
}
