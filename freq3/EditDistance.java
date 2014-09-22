package freq3;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		
		if(word1.length()==0||word2.length()==0)
			return Math.max(word1.length(), word2.length());
		
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		for(int i = 0; i < dp.length; i++)
			dp[i][0] = word2.length();
		for(int j = 0; j < dp[0].length; j++)
			dp[0][j] = word1.length();
		
		
		for(int i = 1; i < dp.length; i++){
			for(int j = 1; j < dp[0].length; j++){
				if(word1.charAt(i)==word2.charAt(j))
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
			}
		}
		return dp[dp.length-1][dp[0].length-1];
    }
}
