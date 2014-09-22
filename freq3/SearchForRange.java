package freq3;

public class SearchForRange {
	public int[] searchRange(int[] A, int target) {
        int start = search(0, A.length-1, A, target, true);
		int end = search(0, A.length-1, A, target, false);
		return new int[]{start, end};
    }
	
	private int search(int start, int end, int[] A, int target, boolean left){
		if(start>end)
			return -1;
		int mid = (start+end)/2;
		
		if(A[mid]==target){
			if(left){
				return (mid==0||A[mid-1]<target)? mid : search(start, mid-1, A, target, left);
			}else{
				return (mid==A.length-1||A[mid+1]>target)? mid : search(mid+1, end, A, target, left);
			}
		}
		else if(A[mid]<target)
			return search(mid+1, end, A, target, left);
		else
			return search(start, mid-1, A, target, left);
	}
	
	public static void main(String args[]){
		new SearchForRange().searchRange(new int[]{1,4},4);
	}
}
