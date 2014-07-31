package s;

public class SearchInsertPosition {
	  public int searchInsert(int[] A, int target) {
		  return searchInsert(A,0, A.length-1, target);
	   }

	private int searchInsert(int[] A, int start, int end, int target) {		
		if(target <= A[start])
			return start;
		if(target > A[end])
			return end+1;
	
		int mid = (start+end)/2;
		if(target>A[start]&&target<=A[mid])
			return searchInsert(A, start, mid, target);
		else
			return searchInsert(A, mid+1, end, target);
	}
}
