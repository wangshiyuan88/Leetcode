package freq3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 2,3,6,7 and target 7, 
//A solution set is: 
//[7] 
//[2, 2, 3] 

public class CombinationSum {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<List<Integer>> ret = new ArrayList<List<Integer>>();
			Arrays.sort(candidates);
			combinationSum(0, 0, candidates, target, new ArrayList<Integer>(), ret);
			return ret;
	    }
		
		public void combinationSum(int index, int currentSum, int[] candidates, int target, List<Integer>list, List<List<Integer>> ret){
			if(index==candidates.length||currentSum>target)
				return;
			if(currentSum==target){
				ret.add(new ArrayList<Integer>(list));
				return;
			}
			list.add(candidates[index]);
			combinationSum(index, currentSum+candidates[index], candidates, target, list, ret);
			list.remove(list.size()-1);
			combinationSum(index+1, currentSum, candidates, target, list, ret);
		}
}
