package freq4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	 public List<List<Integer>> subsets(int[] S) {
	     List<List<Integer>> ret = new ArrayList<List<Integer>>();
	     ret.add(new ArrayList<Integer>());
	     Arrays.sort(S);
	     for(int i = 0; i < S.length; i++){
	    	 List<List<Integer>> tempList = new ArrayList<List<Integer>>();
	    	 for(List<Integer> list : ret){
	    		 List<Integer> temp = new ArrayList<Integer>(list);
	    		 temp.add(i);
	    		 tempList.add(temp);
	    	 }
	    	 ret.addAll(tempList);
	     }
	     return ret;
	 }
}
