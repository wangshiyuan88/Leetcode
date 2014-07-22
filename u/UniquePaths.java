package u;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
        int[][] record = new int[m+1][n+1];
        return countPath1(m, n, record);
    }

	private int countPath1(int m, int n, int[][] record) {
		if(m==1 && n==1)
			return 1;
		if(record[m][n]>0)
			return record[m][n];
		int ways = 0;
		if(m > 1)
			ways += countPath1(m-1, n, record);
		if(n > 1)
			ways += countPath1(m, n-1, record);
		record[m][n] = ways;
		
		return ways;
	}
	
	  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
			int m = obstacleGrid.length;
			int n = obstacleGrid[0].length;
			int[][] record = new int[m][n];
			if(obstacleGrid[m-1][n-1]==1||obstacleGrid[0][0]==1)
			return 0;
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					record[i][j] = -1;
				}
			}
			
			return countPath2(m-1, n-1, obstacleGrid, record);
	    }
		private int countPath2(int m, int n, int[][] obstacleGrid, int[][] record){
			if(m==0&&n==0)
				return 1;
				
			if(record[m][n] >= 0)
				return record[m][n];
			
			if(obstacleGrid[m][n]==1){
				record[m][n] =0;
				return 0;
			}
			int ways = 0;
			if(m > 0){
				ways += countPath2(m-1, n, obstacleGrid, record);
			}
			if(n > 0){
				ways += countPath2(m, n-1, obstacleGrid, record);
			}
			
			record[m][n] = ways;
			return ways;
		}
}
