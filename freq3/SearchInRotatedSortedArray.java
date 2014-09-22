package freq3;

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		return search(0, A.length-1, A, target);
    }
	
	public int search(int start, int end, int[] A, int target){
		if(start>end)
			return -1;
		int mid = (start+end)/2;
		if(A[mid]==target)
			return mid;
		
		if(A[mid]>=A[start]){
			if(target<A[mid]&&target>=A[start])
				return search(start, mid-1, A, target);
			else 
				return search(mid+1, end, A, target);
		}else{
			if(target<=A[end]&&target>A[mid])
				return search(mid+1, end, A, target);
			else
				return search(start, mid-1, A, target);
		}
	}
}
