package r;

public class RemoveDuplicatesFromSortedArray {
	  public int removeDuplicates(int[] A) {
	     if(A.length==0||A.length==1){
	    	 return A.length; 
	     }
		 int prev = 1;
		 int curr = 2;
		while(curr < A.length){
			if(A[curr] == A[prev] && A[curr] == A[prev-1]){
				curr++;
			}else{
				prev++;
				A[prev] = A[curr];
				curr++;
			}
		}
		 
		 return prev+1;
	    }
	  
	  public static void main(String[] args){
		  System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1,1,1}));
	  }
}
