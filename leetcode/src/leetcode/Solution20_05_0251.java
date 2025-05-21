package leetcode;

import java.util.*;

class Solution20_05_0251 {
	public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i : nums){
            hs.merge(i, 1, (o, n)-> o + n);
            if(hs.size() > 2)
                for(Map.Entry<Integer, Integer> entry : hs.entrySet())
                    entry.setValue(entry.getValue() - 1);
        }

        List<Integer> ans = new LinkedList<>();
        if(hs.size() == 0)
            return ans;
        else {
              for(int k : hs.keySet())
                hs.put(k, 0);

            for(int k : nums)
                hs.merge(k, 1, (o, n)-> o+n);
                
            for(Map.Entry<Integer, Integer> entry : hs.entrySet()){
                if(entry.getValue() > nums.length/3)
                    ans.add(entry.getKey());
            }
        }
        return ans;
    }

}
//https://leetcode.com/problems/majority-element-ii/description/