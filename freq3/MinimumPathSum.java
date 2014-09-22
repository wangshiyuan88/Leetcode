package freq3;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int min[] = new int[grid.length];
		for(int i = 0; i < grid[0].length; i++){
			for(int j = 0; j < min.length; j++){
				int fromLeft = i==0? Integer.MAX_VALUE : min[j];
				int fromUp = j == 0? Integer.MAX_VALUE: min[j-1];
				min[j] = grid[i][j];
				if(fromLeft!=Integer.MAX_VALUE||fromUp!=Integer.MAX_VALUE)
					min[j] += Math.min(fromLeft, fromUp);
			}
		}
		return min[grid.length-1];
    }
}
