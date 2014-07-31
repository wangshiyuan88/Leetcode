package s;

import java.util.ArrayList;

public class SubSets {
 public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	  if(S==null){
		  return null;
	  } 
	  return fillWithSubsets(0, new int[]{1,2});
	 }
	 
	 private ArrayList<ArrayList<Integer>> fillWithSubsets(int start, int[] S){
		 if(start == S.length){
			 ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>(); 
			 ret.add(new ArrayList<Integer>());
			 return ret;
		 }
		 
		 int current = S[start];
		 ArrayList<ArrayList<Integer>> retWithoutCurrent = fillWithSubsets(start+1, S);
		 ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		 for(ArrayList<Integer> listWithOutCurrent : retWithoutCurrent){
			 ArrayList<Integer> listWithCurrent = new ArrayList<Integer>(listWithOutCurrent);
			 listWithCurrent.add(0,current);
			 ret.add(listWithCurrent);
			 ret.add(listWithOutCurrent);
		 }
		 return ret;
	 }
}
