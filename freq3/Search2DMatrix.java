package freq3;

public class Search2DMatrix {
	   public boolean searchMatrix(int[][] matrix, int target) {
	        int start = 0;
	        int end = matrix.length*matrix[0].length-1;
	        while(start<=end){
	        	int mid = (start+end)/2;
	        	int midValue = matrix[mid/matrix[0].length][mid%matrix[0].length];
	        	if(midValue==target)
	        		return true;
	        	if(midValue<target)
	        		start = mid+1;
	        	else
	        		end = mid-1;
	        }
			return false;
	    }
}
