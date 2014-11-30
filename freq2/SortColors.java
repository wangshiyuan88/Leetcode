package freq2;

public class SortColors {
	  public void sortColors(int[] A) {
	        int redIndex = 0;
	        int blueIndex = A.length-1;
	    	int i = 0;
	       while(i<=blueIndex){
	        	if(A[i]==0){
	        		swap(redIndex, i, A);
	        		while(redIndex<A.length&&A[redIndex]==0)
	        	    		redIndex++;
	        		i = Math.max(i, redIndex);
	        	}
	        	else if(A[i]==2){
	        		swap(blueIndex, i, A);
	       		 	while(blueIndex>=0&&A[blueIndex]==2)
	       		 		blueIndex--;
	        	}
	        	else
	        		i++;
	        }
	    }
		
		public void swap(int i1, int i2, int[] A){
			int temp = A[i1];
			A[i1] = A[i2];
			A[i2] = temp;
		}
		
		public static void main(String args[]){
			new SortColors().sortColors(new int[]{2,0,0});
		}
}
