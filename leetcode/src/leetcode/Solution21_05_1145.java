package leetcode;

import java.util.HashMap;

class Solution21_05_1145 {
	int maxLen(int arr[]) {
        int n = arr.length;
        int[] presum = new int[n];
        presum[0] = arr[0];
        
        for(int i = 1; i < n; i++)
            presum[i] = arr[i] + presum[i-1];
            
        int ans = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        for(int i = 0; i < n; i++){
            if(hm.containsKey(presum[i])){
                ans = Math.max(ans, i - hm.get(presum[i]));
            } else {
                hm.put(presum[i], i);
            }
        }
        return ans;
    }
}

//https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1


//-31 -48 -90   54    20  95 6 -86  22
//-31 -79 -169  -115  -95 0  6 -80 -58