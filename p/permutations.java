package p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class permutations {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		permute(num, ret, new ArrayList<Integer>());
		return ret;
	}

	private void permute(int[] num, List<List<Integer>> ret,
			ArrayList<Integer> arrayList) {
		if (arrayList.size() == num.length) {
			ret.add(new ArrayList<Integer>(arrayList));
		} else {
			for (int i : num) {
				if (!arrayList.contains(i)) {
					arrayList.add(i);
					permute(num, ret, arrayList);
				}
			}
		}
		if(!arrayList.isEmpty())
		arrayList.remove(arrayList.size() - 1);
	}
	
	public List<List<Integer>> permuteUnique(int[] num) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : num){
			if(!map.containsKey(i)){
				map.put(i, 0);
			}
			map.put(i, map.get(i)+1);
		}
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		permuteUnique(num.length, map, ret, new ArrayList<Integer>());
		return ret;   
    }

	private void permuteUnique(int length, Map<Integer, Integer> map,
			List<List<Integer>> ret, ArrayList<Integer> arrayList) {
		if(length == arrayList.size()){
			ret.add(new ArrayList<Integer>(arrayList));
		}
		else{
			for(int i : map.keySet()){
				if(map.get(i)>0){
					map.put(i, map.get(i)-1);
					arrayList.add(i);
					permuteUnique(length, map, ret, arrayList);
				}
			}
		}
		if(!arrayList.isEmpty()){
			int toRemove = arrayList.remove(arrayList.size() - 1);
			map.put(toRemove, map.get(toRemove)+1);
		}
	}
	
	public static void main(String args[]){
		new permutations().permuteUnique(new int[]{1});
	}
}
