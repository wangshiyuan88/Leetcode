package s;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSetsWithDup {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
		if(S==null)
		  		return null;
		  	Arrays.sort(S);
		  	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		  	ret.add(new ArrayList<Integer>());
		  	
		  	for(int i = 0; i < S.length; i++){
		  		int size = ret.size();
		  		for(int j = 0; j < size; j++){
		  			ArrayList<Integer> current = ret.get(j);
			  			ArrayList<Integer> temp = new ArrayList<Integer>(current);
			  			temp.add(S[i]);
			  			if(!ret.contains(temp))
			  			ret.add(temp);
		  		}
		  	}
			 return ret;
		 }
}
