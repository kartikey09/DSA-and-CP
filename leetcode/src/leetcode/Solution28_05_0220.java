package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

class Solution28_05_0220 {
	int ans = 0;
    public int reversePairs(int[] nums) {
        getSol(nums, 0, nums.length-1);
        return ans;
    }

    ArrayList<Integer> getSol(int[] nums, int l, int r){
        if(l >= r)
            return new ArrayList<Integer>(Arrays.asList(nums[l]));
        int mid = l + (r-l)/2;
        ArrayList<Integer> left = getSol(nums, l, mid);
        ArrayList<Integer> right = getSol(nums, mid+1, r);
        // System.out.println(left);
        // System.out.println(right);
        ArrayList<Integer> ans1 =  merge(left, right);
        // System.out.println(ans);
        return ans1; 
    }

    ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
        ArrayList<Integer> anslist = new ArrayList<Integer>();

        // find the reverse pairs

        for(int i = 0; i < left.size(); i++){
            int k = left.get(i);
            int target = (int)(k%2 == 0? k/2 - 1 : k/2);
            if(k < 0)
                target = k/2 - 1;
            // System.out.println("target is : " + target);
            int idx = binarySearch(right, target);
            if(idx == right.size()) break;
            ans += idx + 1;
        }

        // merge
        while(left.size() > 0 && right.size() > 0){
            if(left.get(0) <= right.get(0))
                anslist.add(left.remove(0));
            else 
                anslist.add(right.remove(0));
        }
        while(left.size() > 0)
            anslist.add(left.remove(0));
        
        while(right.size() > 0)
            anslist.add(right.remove(0));
        
        return anslist;
    }

    int binarySearch(ArrayList<Integer> list, int target){
        int l = 0, r = list.size()-1;
        while(l<=r){
           int m = l+(r-l)/2;
           if(list.get(m) <= target)
                l = m+1;
            else
                r = m-1;
        }
        return r;
    }
}
