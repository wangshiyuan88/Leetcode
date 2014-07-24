package f;

public class FirstMissingPositive {
	//http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
	 public int firstMissingPositive(int[] A) {
	       	int i = 0;
			while(i < A.length){
			    if(A[i]>0&&A[i]<=A.length&&A[i]!=i+1&&A[i]!=A[A[i]-1]){
					int temp = A[A[i]-1];
					A[A[i]-1] = A[i];
					A[i] = temp;
				}
			    else
			    	i++;
			}
			for(i = 0; i < A.length; i++){
				if(A[i]!=i+1)
					return i+1;
			}
				
			return i+1;
	    }
	 
	 public static void main(String args[]){
		 new FirstMissingPositive().firstMissingPositive(new int[]{1,1});
	 }
}
