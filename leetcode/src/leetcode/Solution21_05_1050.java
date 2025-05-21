package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

class Solution21_05_1050 {
	 int ans = 0;
     int inversionCount(int arr[]) {
        ArrayList<Integer> nums = new ArrayList<>();
        for(int x: arr)
            nums.add(x);
        
        countInversions(nums, 0, nums.size()-1);        
        return ans;
    }
    
     ArrayList<Integer> countInversions(ArrayList<Integer> nums, int l, int r){
        if(l == r)
            return new ArrayList<Integer>(Arrays.asList(nums.get(l)));
        
        int mid = (r+l)/2; 
        ArrayList<Integer> left = countInversions(nums, l, mid);
        ArrayList<Integer> right  = countInversions(nums, mid+1, r);
        return merge(left, right);
    }
    
     ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0, r = 0;
        while(l < left.size() && r < right.size()){
            if(left.get(l) <= right.get(r))
                list.add(left.get(l++));
            else {
                list.add(right.get(r++));
                ans += left.size() - l;
            }
        }
        
        while(l < left.size())
            list.add(left.get(l++));
        
        while(r < right.size())
            list.add(right.get(r++));
            
        return list;
    }
}

/*
 		Solution21_05_1050 inst = new Solution21_05_1050();
		int[] arr = new int[] {9,5,1,2,3,6,4};
		System.out.println(inst.inversionCount(arr));
		
		ans is 11
		https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 * */
