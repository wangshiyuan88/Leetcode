package freq5;

public class ClimbingStairs {
//	You are climbing a stair case. It takes n steps to reach to the top.
//	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	
	 public int climbStairs(int n) {
	      int[] ways = new int[n+1];   
	      for(int i = 0;  i < ways.length; i++){
	    	  if(i<=1)
	    		  ways[i] = 1;
	    	  else
	    		  ways[i] = ways[i-2] + ways[i-1]; 
	      }
	      return ways[n];
	 }
}
