package freq3;

public class UniquePaths {
//	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//	How many possible unique paths are there?
	
	public int uniquePaths(int m, int n) {
		int[] dp = new int[m*n];
		for(int i = 0; i < dp.length; i++){
			dp[i] = -1;
		}
		int ret = uniquePathSolver(m-1, n-1, dp, m, n);
		return ret;
	}
	
	public int uniquePathSolver(int i, int j, int[]dp, int m, int n){
		if(i==0&&j==0)
			return 1;
		if(dp[i*n+j]!=-1)
			return dp[i*n+j];
		int ret = 0;
		if(i>0)
			ret += uniquePathSolver(i-1, j, dp, m, n);
		if(j>0)
			ret += uniquePathSolver(i, j-1, dp, m ,n);
		dp[i*n+j] = ret;
		return ret;
	}
	
	public static void main(String args[]){
		new UniquePaths().uniquePaths(2, 1);
	}
}
