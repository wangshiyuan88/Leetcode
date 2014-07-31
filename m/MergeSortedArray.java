package m;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
        int index = A.length+B.length-1;
        int a = A.length-1;
        int b = B.length-1;
        while(a>=0 && b>=0){
        	if(A[a]>B[b]){
        		A[index] = A[a--];
        	}else{
        		A[index] = B[b--];
        	}
        	index--;
        }
        while(a>=0){
        	A[index--] = A[a--];
        }
        while(b>=0){
        	A[index--] = B[b--];
        }
    }
	public static void main(String args[]){
		new MergeSortedArray().merge(new int[]{1}, 1, new int[]{2}, 1);
	}
}
