package s;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSetsWithDup {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if(S==null||S.length==0){
			return ret;
		}
		Arrays.sort(S);
		subsetsWithDup(0, S, new ArrayList<Integer>(), ret);
		return ret;
	}

	private void subsetsWithDup(int start, int[] S, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ret){
		if(start==S.length){
			ret.add(new ArrayList<Integer>(list));
			return;
		}
		int current = start;
		while(current<S.length&&S[current]==S[start]){
			current++;
		}
		ArrayList<Integer> original = new ArrayList<Integer>(list);
		for(int i = 0; i < current-start+1; i++){
			list = new ArrayList<Integer>(original);
			for(int j = 0; j < i; j++){
				list.add(S[start]);
			}
			subsetsWithDup(current, S, list, ret);
		}
	}
}
