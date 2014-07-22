package digit;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	 public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	        Arrays.sort(num);
	        ArrayList<ArrayList<Integer>> answers = new ArrayList<ArrayList<Integer>>();
	        if(num.length<3)return answers;
	        for(int i = 0;  i < num.length-2; i++){
	            if(i== 0||num[i]>num[i-1]){
	               int start = i+1; 
	               int end = num.length-1;
	               while(start < end){
	                   if(num[start]+num[end]==-num[i]){
	                       ArrayList<Integer> temp = new ArrayList<Integer>();
	                       temp.add(num[i]);
	                       temp.add(num[start]);
	                       temp.add(num[end]);
	                       answers.add(temp);
	                       start++;
	                       end--;
	                       while(start<end&&num[start]==num[start-1])start++;
	                      while(start<end&&num[end]==num[end+1])end--;
	                   }
	                   else if(num[start]+num[end]<-num[i]){
	                      start++;
	                   } else{
	                       end--;
	                   }
	               }
	            }
	        }
	        return answers;
	    }
}
