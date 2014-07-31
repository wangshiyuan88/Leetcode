package r;

public class RotateImage {
	 
	public void rotate(int[][] matrix) {
	    
		if(matrix==null||matrix.length==0)
			return;

		for(int r = 0; r < matrix.length/2; r++){	
			int end = matrix[r].length-1-r;
			for(int d = 0; (r+d)<end; d++){
				int temp = matrix[r][r+d];
				matrix[r][r+d] = matrix[end-d][r];
				matrix[end-d][r] = matrix[end][end-d];
				matrix[end][end-d] = matrix[r+d][end];
				matrix[r+d][end] = temp;
			}
			
		}
	 }

}
