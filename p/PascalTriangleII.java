package p;

import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
	 public List<Integer> getRow(int rowIndex) {
	     Integer array[] = new Integer[rowIndex+1];   
	     
	     Integer[] pre = null;
	     for(int row = 0;row <= rowIndex; row++){
	    	 Integer[] current = new Integer[row+1];
	    	 for(int i = row; i < row; i++){
	    		 if(i==0){
	    			 current[i] = 1; 
	    		 }else{
	    			 current[i] = pre[i-1] + pre[i];
	    		 }
	    	 }
	    	 current[row] = 1;
	    	 pre = current;
	     }
	 
		 return Arrays.asList(pre);
	 }
}
