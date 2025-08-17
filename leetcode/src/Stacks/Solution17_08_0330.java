package Stacks;

import java.util.Stack;

public class Solution17_08_0330 {
	class Solution {
	    public int[] asteroidCollision(int[] arr) {
	        Stack<Integer> st = new Stack<>();
	        for(int x : arr){
	            if(st.isEmpty())   {
	                st.push(x);
	                continue;
	            }
	            if(st.peek() < 0){
	                st.push(x);
	            } else {
	                if(x > 0){
	                    st.push(x);
	                } else {
	                    while(!st.isEmpty() && st.peek() > 0 && st.peek() < -1*x) st.pop();
	                    if(st.isEmpty() || st.peek() < 0){
	                        st.push(x);
	                    } else if(st.peek() == -1*x)
	                        st.pop();
	                }
	            }
	        }

	        return st.stream().mapToInt(i -> i).toArray();
	    }
	}
}

//Solved in one GO ! 11mins

//https://leetcode.com/problems/asteroid-collision/submissions/1738366651/
