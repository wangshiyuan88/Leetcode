package e;

public class EditDistance {
	 public int minDistance(String word1, String word2) {
	     int[][] dp = new int[word1.length()+1][word2.length()+1];
	     
	     for(int i = 0; i < word2.length()+1; i++)
	    	 dp[0][i] = i;
	     for(int j = 0; j < word1.length()+1; j++)
	    	 dp[j][0] = j;
	     
	     for(int i = 1; i < dp.length; i++){
	    	 for(int j = 1; j < dp[0].length; j++){
	    		 if(word1.charAt(i-1)==word2.charAt(j-1))
	    			 dp[i][j]=dp[i-1][j-1];
	    		 else{
	    			 dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
	    		 }
	    	 }
	     }
		 
		 return dp[word1.length()][word2.length()]; 
	 }
	 
	 public static void main(String args[]){
		 new EditDistance().minDistance("", "");
	 }
}
