package m;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int k = (A.length+B.length)/2;
		if((A.length + B.length)%2==0){
			return (findMedianSortedArrays(A, 0, A.length-1,B, 0, B.length-1, k) + findMedianSortedArrays(A, 0, A.length-1,B, 0, B.length-1, k+1))/2;
        }
		else
			return findMedianSortedArrays(A, 0, A.length-1,B, 0, B.length-1, k+1);
    }
	
	public double findMedianSortedArrays(int A[], int astart, int aend, int B[], int bstart, int bend, int k){
		
		if(astart>aend){
			return B[bstart+k-1];
		}
		if(bstart>bend){
			return A[astart+k-1];
		}
		if(k == 1)
			return Math.min(A[astart], B[bstart]);
		int m  = aend - astart+1;
		int n  = bend - bstart+1;
		if(m>n)
			return findMedianSortedArrays(B, bstart, bend, A, astart, aend, k);
		int midA = Math.min(k/2, m);
		int midB = k - midA;
		
		if(A[astart+midA-1]>B[bstart+midB-1]){
			return findMedianSortedArrays(A, astart, aend, B, bstart+midB, bend, k-midB);
		}else if(A[astart+midA-1]<B[bstart+midB-1]){
			return findMedianSortedArrays(A, astart+midA, aend, B, bstart, bend, k-midA);
		}else
			return A[astart+midA-1];
		
	}
	
	public static void main(String args[]){
	System.out.println(	new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,2}, new int[]{1,2,3}));
	}
}
