package freq4;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	 public List<List<Integer>> combine(int n, int k) {
		 List<List<Integer>> ret = new ArrayList<List<Integer>>();
		 combine(1, n, k, new ArrayList<Integer>(),ret);
		 return ret;
	 }

	private void combine(int start, int n, int k, List<Integer> list, List<List<Integer>> ret) {
		if(list.size()==k){
			ret.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = start; i <= n+1-k+list.size(); i++){
			list.add(i);
			combine(i+1, n, k, list, ret);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String args[]){
		new Combinations().combine(1, 1);
	}
}
