package freq3;

public class UniquePathsII {
	  
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[] dp = new int[obstacleGrid.length*obstacleGrid[0].length];
		for(int i = 0; i < dp.length; i++)
			dp[i] = -1;
		return uniquePathsWithObstacles(0, 0, obstacleGrid, dp);
	}

	private int uniquePathsWithObstacles(int i, int j, int[][] obstacleGrid,
			int[] dp) {
		if(i>=obstacleGrid.length||j>=obstacleGrid[0].length||obstacleGrid[i][j]==1)
			return 0;
		if(i==obstacleGrid.length-1&&j==obstacleGrid[0].length-1)
			return 1;
		if(dp[i*obstacleGrid[0].length+j]!=-1)
			return dp[i*obstacleGrid[0].length+j];
		int ret = uniquePathsWithObstacles(i+1, j, obstacleGrid, dp) + uniquePathsWithObstacles(i, j+1, obstacleGrid, dp);
		dp[i*obstacleGrid[0].length+j] = ret;
		return ret;
	}
	
	public static void main(String args[]){
		new UniquePathsII().uniquePathsWithObstacles(new int[][]{{0,0},{0,0}});
	}
}
