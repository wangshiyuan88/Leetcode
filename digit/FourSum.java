package digit;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	 public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        Arrays.sort(num);
	        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	        for(int i = 0; i < num.length-3; i++){
	            if(i==0||num[i-1]<num[i])
	            find3Sum(list, i+1, num, target - num[i]);
	        }
	        return list;
	    }
	    private static void find3Sum(ArrayList<ArrayList<Integer>>list, int startFrom, int[] num, int target){
	        
	        for(int i = startFrom; i< num.length-2 ; i++){
	            if(i==startFrom||num[i-1]<num[i]){
	                int temp = target - num[i];
	                int start = i+1;
	                int end = num.length-1;
	                while(start<end){
	                    if(num[start]+num[end]==temp){
	                        ArrayList<Integer> answer = new ArrayList<Integer>();
	                        answer.add(num[startFrom-1]);
	                        answer.add(num[i]);
	                        answer.add(num[start]);
	                        answer.add(num[end]);
	                        list.add(answer);
	                        start++;
	                        end--;
	                        while(num[start-1]==num[start]&&start<end){
		                        start++;
		                    }
	                        while(num[end+1]==num[end]&&start<end)
		                        end--;
	                    } else if(num[start]+num[end]>temp){
	                        end--;
	                    } else {
	                        start++;
	                    }
	                }
	            }
	        }
	    }
}
