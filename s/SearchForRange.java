package s;

public class SearchForRange {
	public int[] searchRange(int[] A, int target) {
		int start = searchRange(A, 0, A.length-1, target, true);
		int end = searchRange(A, 0, A.length-1, target, false);
		return new int[]{start, end};
    }

	private int searchRange(int[] A, int i, int j, int target, boolean left) {
		if(i>j)
			return -1;
		int mid = (i+j)/2;
		
		if(target > A[mid]){
			return searchRange(A, mid+1, j, target, left );
		}
		else if(target < A[mid]){
			return searchRange(A, i, mid-1, target, left);
		} else {
			if(left){
				if(mid==0||A[mid]>A[mid-1]){
					return mid;
				}else
					return searchRange(A, i, mid-1, target, left);
			}else{
				if(mid==A.length-1||A[mid]<A[mid+1])
					return mid;
				else 
					return searchRange(A, mid+1, j, target, left);
			}
		}
	}
}
