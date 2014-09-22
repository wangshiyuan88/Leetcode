package freq4;

public class MedianOfTwoSortedArrays {
	// There are two sorted arrays A and B of size m and n respectively. 
	//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	
	public double findMedianSortedArrays(int A[], int B[]) {
        int totalLength = A.length+ B.length;
        if(totalLength%2==0)
        	return (findMedianSortedArrays(totalLength/2, 0, A.length-1, A, 0, B.length-1, B) + findMedianSortedArrays(totalLength/2+1, 0, A.length-1, A, 0, B.length-1, B))/2;
        else
        	return findMedianSortedArrays(totalLength/2+1, 0, A.length-1, A, 0, B.length-1, B);
    }

	private double findMedianSortedArrays(int target, int as, int ae, int[] A, int bs,
			int be, int[] B) {
		if(as>ae)
			return B[bs+target-1];
		if(bs>be)
			return A[as+target-1];
		if(target==1)
			return A[as] > B[bs]? B[bs] : A[as];
		int alength = ae-as+1;
		int blength = be-bs+1;
		if(blength<alength)
			return findMedianSortedArrays(target, bs, be, B, as, ae, A);
		int am = Math.min(alength, target/2);
		int bm = target - am;
		if(A[as+am-1]>B[bs+bm-1])
			return findMedianSortedArrays(target-bm, as, ae, A, bs+bm, be, B);
		else if(A[as+am-1]<B[bs+bm-1])
			return findMedianSortedArrays(target-am, as+am, ae, A, bs, be, B);
		return A[as+am-1];
	}
	

	public static void main(String args[]){		
		new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,1}, new int[]{1,2});
	}
}
