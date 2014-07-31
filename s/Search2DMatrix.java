package s;
// 2D to 1D
public class Search2DMatrix {
	  public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix==null||matrix.length==0||matrix[0].length==0)
	        	return false;
	        int start = 0;
	        int end = matrix.length*matrix[0].length-1;
	        while(start<end){
	        	int mid = (start+end)/2;
	        	int m = mid/matrix[0].length;
	        	int n = mid%matrix[0].length;
	        	
	        	if(matrix[m][n]==target)
	        		return true;
	        	else if(matrix[m][n]<target)
	        		start = mid+1;
	        	else
	        		end = mid - 1;
	        }
	        return false;
	    }
}
