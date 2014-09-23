package freq3;

public class PalindromePartitioningII {
	public int minCut(String s) {
		int dp[] = new int[s.length()+1];
		boolean [][] matrix = new boolean[s.length()][s.length()];
		for(int i = dp.length-1; i >=0; i--){
			dp[i] = s.length() -i;  // dp[i] the number of palindrome part from 0(inclusive) to i(exclusive), dp[s.length()] has to be zero, dp[0] should be s.length()
									// since maximal number of palindrome is the number of the character
		}
		
		for(int i = s.length()-1; i >=0; i--){
			for(int j = i; j < s.length(); j++){
				 if((s.charAt(i)==s.charAt(j))&&(j-i < 2||matrix[i+1][j-1])){
					 matrix[i][j] = true;
					 dp[i] = Math.min(dp[i], 1+dp[j+1]);
				 }
			}
		}
		return dp[0]-1;
	}
	
	public static void main(String args[]){
		new PalindromePartitioningII().minCut("ab");
	}
}
