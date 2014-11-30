package freq2;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
	// Time limit Exceed
	
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(num==null||num.length==0)
			return list;
		permuteUnique(0, num, list);
		return list;
    }
	
	public void permuteUnique(int start, int[] num, List<List<Integer>> list){
		if(start == num.length-1){
			list.add(arrayToList(num));
			return;
		}
		
		for(int i = start; i < num.length; i++){
			if(i==start){
				permuteUnique(start+1, num, list);
			}else if(num[i]!=num[start]){
				swap(num, i, start);
				permuteUnique(start+1, num, list);
				swap(num, i, start);
			}
		}
		
	}
	
	public List<Integer> arrayToList(int[] num){
		List<Integer> ret = new ArrayList<Integer>();
		for(int n : num){
			ret.add(n);
		}
		return ret;
	}
	public void swap(int[] num, int i1, int i2){
		int temp = num[i1];
		num[i1] = num[i2];
		num[i2] = temp;
	}
	
	public static void main(String args[]){
		new PermutationsII().permuteUnique(new int[]{-1,-1,3,-1});
	}
}
