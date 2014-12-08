package p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
	public List<List<Integer>> permuteUnique2(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num.length==0)
            return result;
        permuteUnique(0, num, result);
        return result;
    }
    
    private void permuteUnique(int start, int[] num,  List<List<Integer>> result){
        if(start==num.length){
            List<Integer> list = new ArrayList<Integer>();
            for(int n : num){
                list.add(n);
            }
            result.add(list);
        }
        HashSet<Integer> set =  new HashSet<Integer>();
        for(int i = start; i < num.length; i++){
            if(i==start||(num[i]!=num[start])&&!set.contains(num[i])){
               set.add(num[i]);
               swap(start, i, num);
               permuteUnique(start+1, num, result);
               swap(start, i, num);
            }
        }
            
    }
	
    public void swap(int i, int j, int[] num){
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
	public static void main(String args[]){
		System.out.println(new permutations().permuteUnique2(new int[]{2,1,1}));
	}
}
