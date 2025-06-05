package Recursion;

import java.util.LinkedList;
import java.util.List;

public class Solution05_06_0137 {
	public List<String> generateParenthesis(int n) {
        LinkedList<String> ans = new LinkedList<>();
        getSol(0, 0, n, "", ans);
        return ans;
    }

    void getSol(int open, int close, int target, String ansSoFar, LinkedList<String> ansList){
        if(open == close && close == target){
            ansList.add(ansSoFar);
            return;
        }

        if(open != target){
            getSol(open+1, close, target, ansSoFar + "(", ansList);
        }

        if(close < open){
            getSol(open, close+1, target, ansSoFar + ")", ansList);
        }

    }
}

//https://leetcode.com/problems/generate-parentheses/