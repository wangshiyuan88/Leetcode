package freq2;

public class RotateImage {
	// start, end, distance
    public void rotate(int[][] matrix) {
		if(matrix==null||matrix.length<=1)
			return;
		int l = matrix.length;
		for(int start = 0; start < l/2; start++){
			int end = l-1-start;
			for(int distance = 0; start+distance < end; distance++){
				int temp = matrix[start][start+distance];
				matrix[start][start+distance] = matrix[end-distance][start];
				matrix[end-distance][start] = matrix[end][end-distance];
				matrix[end][end-distance] = matrix[start+distance][end];
				matrix[start+distance][end] = temp;
			}
		}
    }
}
