package i;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        
		if(s3.length()!=s1.length()+s2.length()){
			return false;
		}
		boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
		
		for(int i = 0; i < dp.length; i++){
			dp[i][0] = s3.startsWith(s1.substring(0, i));
		}
		for(int j = 0; j < dp[0].length; j++){
			dp[0][j] = s3.startsWith(s2.substring(0, j));
		}
		
		for(int i = 1; i < dp.length; i++){
			for(int j = 1; j < dp[0].length; j++){
				dp[i][j] = (dp[i-1][j]&&s3.charAt(i+j-1)==s1.charAt(i-1))||
						(dp[i][j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1));
			}
		}
		return dp[dp.length-1][dp[0].length-1];
    }
}
