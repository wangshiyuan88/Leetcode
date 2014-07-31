package m;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		minPathSum(0, 0, grid, grid.length,  grid[0].length);
		return grid[0][0];
        
    }

	private void minPathSum(int x, int y, int[][] grid, int m, int n) {
		if(x== m-1 && y==n-1)
			return;
		int current = grid[x][y];
		int right = Integer.MAX_VALUE;
		int down = Integer.MAX_VALUE;
		if(y<=n-2){
			minPathSum(x, y+1, grid, m, n);
			right = y <= n-2? grid[x][y+1] : Integer.MAX_VALUE;
		}
		if(x <= m-2){
			down = x <= m-2? grid[x+1][y] : Integer.MAX_VALUE;
		}
		grid[x][y] = Math.min(right, down) + current;
	}
}
