package d;

public class DecodeWays {
	 public int numDecodings(String s) {
		 int[] dp = new int[2];
		 dp[0] = 1; 
		 dp[1] = 1;
		 if(s.length()== 0||s.charAt(0)=='0')
			 return 0;
		 for(int i = 1; i <s.length(); i++){
			 int doubleDigit = Integer.parseInt(s.substring(i-1,i+1));
			 int singleDigit = Integer.parseInt(s.substring(i, i+1));
			 int ret = 0;
			 if(doubleDigit>=10&&doubleDigit<=26)
				 ret += dp[0]; 
			 if(singleDigit!=0)
				 ret += dp[1];
			 dp[0] = dp[1];
			 dp[1] = ret;
	   }
		 return dp[1];
	 }
	 
	 public static void main(String args[]){
		 new DecodeWays().numDecodings("11");
	 }
}
