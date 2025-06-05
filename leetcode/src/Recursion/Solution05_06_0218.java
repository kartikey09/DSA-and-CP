package Recursion;

import java.util.LinkedList;
import java.util.List;

public class Solution05_06_0218 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ansList = new LinkedList<>();
        getSol(0, new LinkedList<Integer>(), ansList, nums);
        return ansList;
    }

    void getSol(int pos, LinkedList<Integer> ansSoFar, List<List<Integer>> ansList, int[] nums){
        if(pos == nums.length){
            LinkedList<Integer> finalList = new LinkedList<>(ansSoFar);
            ansList.add(finalList);
            return;
        }

        getSol(pos+1, ansSoFar, ansList, nums);
        ansSoFar.add(nums[pos]);
        getSol(pos+1, ansSoFar, ansList, nums);
        ansSoFar.removeLast();
    }
}

//https://leetcode.com/problems/subsets/