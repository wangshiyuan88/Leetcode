package freq3;

public class MaximumSubarray {
//	Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
//	the contiguous subarray [4,−1,2,1] has the largest sum = 6.
	
	 public int maxSubArray(int[] A) {
	     int max = Integer.MIN_VALUE;
	     int sum = 0;
	     for(int i : A){
	    	 if(sum>0)
	    		 sum += i;
	    	 else 
	    		 sum = i;
	    	 max = Math.max(sum, max);
	     }
		 return max;
	  }
}
