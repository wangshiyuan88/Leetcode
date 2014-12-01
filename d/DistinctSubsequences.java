package d;

public class DistinctSubsequences {
	// http://blog.csdn.net/abcbc/article/details/8978146
	public int numDistinct(String S, String T) {
		int[][] dp = new int[S.length()+1][T.length()+1];
		dp[0][0] = 1;
		for(int i = 1; i < dp.length; i++){
			dp[i][0] = 1;
		}
		for(int i = 1; i < dp[0].length; i++){
			dp[0][i] = 0;
		}
		for(int i = 1; i <dp.length; i++){
			for(int j = 1; j < dp[0].length; j++){
				dp[i][j] = dp[i-1][j] + (S.charAt(i-1)==T.charAt(j-1)? dp[i-1][j-1]:0);
			}
		}
		return dp[S.length()][T.length()];
    }

	public static void main(String args[]){
		System.out.println(new DistinctSubsequences().numDistinct("bbi", "bi"));
	}
}
