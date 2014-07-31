package c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
		combinationSum(candidates, target, 0, new ArrayList<Integer>(), ret);
		return ret;
    }
	private void combinationSum(int[] candidates, int target,
			int start, ArrayList<Integer> current, List<List<Integer>> ret) {
		if(target==0){
			ret.add(new ArrayList<Integer>(current));
			return;
		}
		
		for(int i = start; i <candidates.length; i++){
			if(candidates[i]>target)
				break;
			current.add(candidates[i]);
			combinationSum(candidates, target-candidates[i], i, current, ret);
			current.remove(current.size()-1);
		}
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
		combinationSum2(candidates, target, 0, new ArrayList<Integer>(), ret);
		return ret;
    }
	private void combinationSum2(int[] candidates, int target,
			int start, ArrayList<Integer> current, List<List<Integer>> ret) {
		if(target==0){
			ret.add(new ArrayList<Integer>(current));
			return;
		}
		
		for(int i = start; i <candidates.length; i++){
			if(candidates[i]>target)
				break;
			if(i==start||candidates[i]!=candidates[i-1]){
				current.add(candidates[i]);
				combinationSum2(candidates, target-candidates[i], i+1, current, ret);
				current.remove(current.size()-1);
			}
		}
	}
}
