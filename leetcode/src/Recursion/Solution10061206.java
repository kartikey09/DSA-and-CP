package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution10061206 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int x : candidates)
            hm.merge(x, 1, (ol, nw)-> ol+nw);
        
        int freq[][] = new int[hm.size()][2];
        Iterator<Map.Entry<Integer, Integer>> itr = hm.entrySet().iterator();
        int i = 0;
        while(itr.hasNext()){
            Map.Entry<Integer, Integer> inst = itr.next();
            freq[i][0] = inst.getKey();
            freq[i][1] = inst.getValue();
            i++;
        }
        List<List<Integer>> ansList = new ArrayList<>();
        ArrayList<Integer> asf = new ArrayList<>();
        getSol(freq, 0, 0, asf, ansList, target);
        return ansList;
    }

    void getSol(int[][] freq, int pos, int ssf, ArrayList<Integer> asf, List<List<Integer>> ansList, int target){
        if(pos >= freq.length || ssf > target)
            return;
        else if(ssf == target){
            ansList.add(new ArrayList<>(asf));
            return;
        }

        if(freq[pos][1] >= 1){
            freq[pos][1]--;
            asf.add(freq[pos][0]);
            getSol(freq, pos, ssf + freq[pos][0], asf, ansList, target);
            asf.removeLast();
            freq[pos][1]++;
        }

        getSol(freq, pos+1, ssf, asf, ansList, target);
    }
}
