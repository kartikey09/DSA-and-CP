package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution06060943 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> asf = new ArrayList<>();
        getSol(candidates, target, 0, 0, asf, ans);
        return ans;
    }

    void getSol(int[] candidates, int target, int pos, int asf, List<Integer> lsf, List<List<Integer>> ans){
        if(asf >= target){
            if(asf > target)
                return;
            ans.add(new ArrayList<Integer>(lsf));
            return;
        }
        if(pos >= candidates.length)
            return;

        lsf.add(candidates[pos]);
        getSol(candidates, target, pos, asf+candidates[pos], lsf, ans);
        lsf.removeLast();
        getSol(candidates, target, pos+1, asf, lsf, ans);
    }
}

//https://leetcode.com/problems/combination-sum/