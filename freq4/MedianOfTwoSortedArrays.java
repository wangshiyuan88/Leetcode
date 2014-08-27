package freq4;

public class MedianOfTwoSortedArrays {
	// There are two sorted arrays A and B of size m and n respectively. 
	//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	
	public double findMedianSortedArrays(int A[], int B[]) {
        int totalLength = A.length+ B.length;
        if(totalLength%2==0)
        	return (findMedianSortedArrays(totalLength/2-1, 0, A.length-1, A, 0, B.length-1, B) + findMedianSortedArrays(totalLength/2, 0, A.length-1, A, 0, B.length-1, B))/2;
        else
        	return findMedianSortedArrays(totalLength/2, 0, A.length-1, A, 0, B.length-1, B);
    }

	private double findMedianSortedArrays(int target, int as, int ae, int[] A, int bs,
			int be, int[] B) {
		if(ae < as){
			return B[bs+target];
		}
		if(be < bs)
			return A[as+target];
		if(target==0)
			return A[as] < B[bs] ? A[as] : B[bs];
		int am = (as+ae)/2;
		int bm = (bs+be)/2;
		int currentMaxIndex = am-as+1+bm-bs;
		if(target>currentMaxIndex){
			if(A[am]>B[bm])
				return findMedianSortedArrays(target - (bm-bs+1), as, ae, A, bm+1, be, B);
			else
				return findMedianSortedArrays(target - (am-as+1), am+1, ae, A, bs, be, B);
		}else{
			if(A[am]>B[bm])
				return findMedianSortedArrays(target-1, as, am-1, A, bs, be, B);
			else
				return findMedianSortedArrays(target-1, as, ae, A, bs, bm-1, B);
		}
	}
	
	public static void main(String args[]){
		new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,2}, new int[]{1,2,3});
	}
}
