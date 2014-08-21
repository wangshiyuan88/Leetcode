package freq4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
//	Given a collection of numbers, return all possible permutations.
//  For example,
//	[1,2,3] have the following permutations:
//	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		permute(num, 0, ret);
		return ret;
    }
	private void permute(int[] num, int start, List<List<Integer>> ret) {
		if(start==num.length){
			ret.add(convertToList(num));
			return;
		}
		
		for(int i = start; i < num.length; i ++){
			swap(num, start, i);
			permute(num, start+1, ret);
			swap(num, start, i);
		}
	
}
	private void swap(int[] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	private List<Integer> convertToList(int[] num){
		List<Integer> ret = new ArrayList<Integer>();
		for(int i : num){
			ret.add(i);
		}
		return ret;
	}
}
