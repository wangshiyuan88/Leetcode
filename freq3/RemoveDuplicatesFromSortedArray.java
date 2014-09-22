package freq3;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
	    if(A==null||A.length==0)
	    	return 0;
		int before = 0;
	    int current = 0;
	    int last = A[0];
	    while(current<A.length){
	    	if(A[current]!=last){
	    		A[++before]=A[current];
	    		last = A[current];
	    	}		
	    	current++;
	    }
	    return before+1;
    }
}
