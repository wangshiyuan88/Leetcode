package s;


public class ScrambleString {

// 	 This solution is the brute force solution, can't pass the test. The time complexity is O(5^n) 	
//	 public boolean isScramble(String s1, String s2) {
//		 if(s1.length()!=s2.length())
//			 return false;
//		 if(s1.equals(s2))
//			 return true;
//		 int[] charCounter = new int[26];
//		 
//		 for(int i = 0; i < s1.length(); i++){
//			 charCounter[s1.charAt(i)-'a']++;
//		 }
//		 for(int i = 0; i < s2.length(); i++){
//			 charCounter[s2.charAt(i)-'a']--;
//			 if(charCounter[s2.charAt(i)-'a']<0)
//				 return false;
//		 }
//		 
//		 for(int i = 1; i < s1.length(); i++){
//			 if(isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i),s2.substring(i)))
//					 return true;
//			 if(isScramble(s1.substring(0,i),s2.substring(s2.length()-i))&&isScramble(s1.substring(i),s2.substring(0, s2.length()-i)))
//				 return true;
//		 }
//		 
//		 return false;
//	 }
	
	public boolean isScramble(String s1, String s2){
		
	 if(s1.length()!=s2.length())
	 return false;
	 if(s1.equals(s2))
		 return true;
	 int[] charCounter = new int[26];
	 
	 for(int i = 0; i < s1.length(); i++){
		 charCounter[s1.charAt(i)-'a']++;
	 }
	 for(int i = 0; i < s2.length(); i++){
		 charCounter[s2.charAt(i)-'a']--;
		 if(charCounter[s2.charAt(i)-'a']<0)
			 return false;
	 }
	int length = s1.length();
		
	boolean[][][] matrix = new boolean[length][length][length];
	
	for(int i = 0; i < length; i++){
		for(int j = 0; j < length ; j++){
			matrix[i][j][1] = s1.charAt(i)==s2.charAt(j);
		}
	}
	
	for(int len = 2; len <= length; len++ ){
		for(int i = 0; i <= length-len; i++){
			for(int j = 0; j <= length-len; j++){
				for(int k = 1; k < len; k++ ){
					matrix[i][j][len] |= (matrix[i][j][k]&&matrix[i+k][j+k][len-k])||
							(matrix[i][j+len-k][k]&&matrix[i+k][j][len-k]); 
				}
			}
		}
	}
		return matrix[0][0][length];
	}
}
