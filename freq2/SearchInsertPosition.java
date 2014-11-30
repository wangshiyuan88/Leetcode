package freq2;

public class SearchInsertPosition {
	 public int searchInsert(int[] A, int target) {
		  return searchInsert(A, target, 0, A.length-1);
	 }

	private int searchInsert(int[] A, int target, int start, int end) {
		if(target>A[end])
			return end+1;
		if(target<=A[start])
			return start;
		int mid = (start+end)/2;
		if(target>=A[start]&&target<=A[mid])
			return searchInsert(A, target, start, mid);
		else
			return searchInsert(A, target, mid+1, end);
	}
}
