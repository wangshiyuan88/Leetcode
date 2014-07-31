package s;

public class SortColors {
	  public void sortColors(int[] A) {
	        
		  	int before = 0;
	        int after = A.length-1;
	        int current = 0;
	        
	        while(before<A.length&&A[before]==0)before++;
	        while(after>=0&&A[after]==2)after--;
	       
	        while(current <= after){
	        	if(A[current]==0 && current> before){
	        		A[current] = A[before];
	        		A[before++] = 0;
	        		continue;
	        	}
	        	if(A[current]==2){
	        		A[current] = A[after];
	        		A[after--] = 2;
	        		continue;
	        	}
	        	current++;
	        }   
	   }
}
