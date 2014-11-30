package freq2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	 public List<List<Integer>> combinationSum2(int[] num, int target) {
		 List<List<Integer>> ret = new ArrayList<List<Integer>>();
		 if(num==null||num.length==0)
			 return ret;
		 Arrays.sort(num);
		 combinationSum2(0, num, target, new ArrayList<Integer>(), ret);
		 return ret;
	 }

	private void combinationSum2(int start, int[] num, int target,
			ArrayList<Integer> list, List<List<Integer>> ret) {
		if(target==0){
			ret.add(new ArrayList<Integer>(list));
		}
		if(target<0||start==num.length)
			return;
		for(int i = start; i < num.length; i++){
			if(i==start||num[i-1]!=num[i]){
				list.add(num[i]);
				combinationSum2(i+1, num, target-num[i], list, ret);
				list.remove(list.size()-1);
			}
		}
	}
}
