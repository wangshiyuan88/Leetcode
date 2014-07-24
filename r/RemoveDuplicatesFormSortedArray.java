package r;

public class RemoveDuplicatesFormSortedArray {
	public int removeDuplicates(int[] A) {
		if(A==null||A.length==0||A.length==1){
			return 0;
		}
		int p = 0; 
		int q = 0;
		
		while(q < A.length){
			if(A[p]==A[q]){
				q++;
			}
			else{
				p++;
				A[p] = A[q];
				q++;
			}
		}
		return p+1;
    }
	
	public int removeDuplicatesII(int[] A) {
		if(A==null||A.length==0||A.length==1){
			return 0;
		}
		int p = 0; 
		int q = 0;
		boolean duplicateOnce = false;
		
		while(q < A.length){
			if(A[p]==A[q]){
				q++;
				if(!duplicateOnce){
					duplicateOnce = true;
					p++;
				}
			}
			else{
				p++;
				A[p] = A[q];
				q++;
				duplicateOnce = false;
			}
		}
		return p+1;
    }
}
