package freq4;

public class RemoveElement {
//	Given an array and a value, remove all instances of that value in place and return the new length.
//	The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	
	public int removeElement(int[] A, int elem) {
	    int end = A.length-1;
	    int start = 0;
	    while(start<=end){ // Corner case [1], 1
	    	while(end>=0&&A[end]==elem)
	    		end--;
	    	if(start<end && A[start]==elem){
	    		A[start] = A[end];
	    		A[end]=elem;
	    	}
	    	start++;
	    }
	    return end+1;
	}
}
