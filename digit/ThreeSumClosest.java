package digit;

import java.util.Arrays;

public class ThreeSumClosest {

	  public static int threeSumClosest(int[] num, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	         int temp = Integer.MAX_VALUE/2;
	        Arrays.sort(num);
	        for(int i = 0; i < num.length-2; i++){
	        	//System.out.println(i);
	        	if(i==0||num[i]>num[i-1]){
	               System.out.println(i);
	        		int start = i+1;
	                int end = num.length-1;
	               
	                while(start < end){
	                    int sum = num[i]+num[start]+num[end];
	                    if(sum==target){
	                        return target;
	                    }else if(sum>target){
	                    	System.out.println("!"+temp);
	                    	if(Math.abs(target-temp)>Math.abs(target-sum)){
	                            temp = sum;
	                            System.out.println("!"+temp);
	                        }
	                         end--;
	                         while(end>0&&num[end]==num[end+1])
	                         end--;
	                    }else{
	                    	
	                    	 System.out.println(Math.abs(target-temp)+" "+(target-sum));
	                    	if(Math.abs(target-temp)>Math.abs(target-sum)){
	                    		temp = sum;
	                            System.out.println("?"+temp);    
	                        }
	                         start++;
	                         while(start<end&&num[start]==num[start-1])
	                         start++;
	                    }
	                	
	                }
	            }
	        }
	        return temp;
	        
	    }
}
