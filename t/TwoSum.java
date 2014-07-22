package t;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	 public int[] twoSum(int[] numbers, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	     Map<Integer, Integer> number_index = new HashMap<Integer, Integer>();
	     int[] array = numbers.clone();
	     for(int i = 0 ; i < numbers.length; i++){
	    	 number_index.put(numbers[i], i);
	     }
		 Arrays.sort(numbers);
	     
	     int index1 = 0;
	     int index2 = numbers.length-1;
	     while(index1 < index2){
	    	 int sum = numbers[index1]+numbers[index2];
	    	 if(sum ==target){
	    		 if(numbers[index1]==numbers[index2]){  // If the case is [4,4], 8
	    			 int second = number_index.get(numbers[index1]);
	    			 for(int i = 0; i < number_index.get(numbers[index1]);i++){
	    				 if(array[i]==numbers[index1]){
	    					 int first = i;
	    					 return new int[]{first+1,second+1 };
	    				 }
	    			 }
	    		 }
	    		 int first = number_index.get(numbers[index1]) < number_index.get(numbers[index2])? number_index.get(numbers[index1]) : number_index.get(numbers[index2]); 
	    		 int second = number_index.get(numbers[index1]) > number_index.get(numbers[index2])? number_index.get(numbers[index1]) : number_index.get(numbers[index2]); 
	    		 
	    		 return new int[]{first+1,second+1};
	    	 }
	    	 else if(sum < target){
	    		 index1 ++;
	    	 }else{
	    		 index2 --;
	    	 }
	     }
		 return null;
	 }
}
