package p;


public class PalindromePartitioningII {
	 public int minCut(String s) {
		 int[] dp = new int[s.length()+1];
		 boolean[][] matrix = new boolean[s.length()][s.length()];
		 for(int i = 0; i < dp.length; i++){
			 dp[i] = s.length()-i;
		 }

		 for(int i = s.length()-1; i >=0; i-- ){
			 for(int j = i; j < s.length(); j++){
				 // check if sub string from i to j+1(Exclusive), is palindrome string
				 if((s.charAt(i)==s.charAt(j))&&(j-i < 2||matrix[i+1][j-1])){
					 matrix[i][j] = true;
					 dp[i] = Math.min(dp[i], 1+dp[j+1]);
				 }
			 }
		 }
		 return dp[0]-1;
	  }


	 public static void main(String args[]){
		 System.out.println(new PalindromePartitioningII().minCut("bab"));
	 }
}
