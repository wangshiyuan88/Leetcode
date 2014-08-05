package freq5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	 public List<List<Integer>> threeSum(int[] num) {
		 List<List<Integer>> ret = new ArrayList<List<Integer>>();
		 if(num==null||num.length<3)
			 return ret;
		 Arrays.sort(num);
		 for(int i = 0; i < num.length-2; i++){
			 if(i>0&&num[i]==num[i-1])
				 continue;
			 int current = 0 - num[i];
			 int s = i+1;
			 int e = num.length-1;
			 while(s<e){
				 if(num[s]+num[e]==current){
					 List<Integer> list = new ArrayList<Integer>();
					 int start = num[s];
					 int end = num[e];
					 list.add(num[i]);
					 list.add(num[s]);
					 list.add(num[e]);
					 ret.add(list);
					 while(s<e&&num[s]==start)
						 s++;
					 while(s<e&&num[e]==end)
						 e--;
				 }else if(num[s]+num[e]<current){
					 s++;
				 }else{
					 e--;
				 }
			 }
		 }
		 return ret;
	  }
}
