package freq3;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		return search(0, A.length-1, target, A);
    }
	
	private boolean search(int start, int end, int target, int[]A){
		if(start>end)
			return false;
		int mid = (start+end)/2;
		int current = A[mid];
		if(current==target)
			return true;
		if(current<A[end]){
			if(A[mid]<target&&target<=A[end])
				return search(mid+1, end, target, A);
			else
				return search(start, mid-1, target,A);
		}else if(current == A[end]){
				if(search(start, mid-1, target, A))
					return true;
				else 
					return search(mid+1, end, target, A);
		}else{
			if(target>A[end]&&target<A[mid])
				return search(start, mid-1, target, A);
			else
				return search(mid+1, end, target, A);
		}
	}
	
	public static void main(String args[]){
		new SearchInRotatedSortedArrayII().search(new int[]{1,1,1,1,3}, 3);
	}
}
