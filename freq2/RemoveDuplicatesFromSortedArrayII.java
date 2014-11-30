package freq2;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] A) {
		if(A==null||A.length<=2)
			return A.length;
		int newEnd = 1;
		int counter = 1;
		int before = A[0];
		for(int i = 1; i < A.length; i++){
			if(A[i]!=before||(A[i]==before&&counter<2)){
				A[newEnd] = A[i];
				newEnd++;
				if(A[i]!=before)
					counter=0;
				before = A[i];
			}
			counter++;
		}
		return newEnd;
    }
	
	public static void main(String [] args){
		new RemoveDuplicatesFromSortedArrayII().removeDuplicates(new int[]{1,1,1});
	}
}
