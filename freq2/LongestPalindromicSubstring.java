package freq2;

public class LongestPalindromicSubstring {
//	Given a string S, find the longest palindromic substring in S. 
//	You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
	public String longestPalindrome(String s) {
		if(s==null||s.length()<=1)
			return s;
		String ret = "";
		for(int piv = 0; piv < s.length(); piv++){
			ret = findPalindrom(piv, piv+1, s, ret);
			ret = findPalindrom(piv, piv, s, ret);
		}
		return ret;
    }
	public String findPalindrom(int before, int after, String s, String ret){
		while(before>=0&&after<s.length()&&s.charAt(before)==s.charAt(after)){
			before--;
			after++;
		}	
		return ret.length() < s.substring(before+1, after).length()? s.substring(before+1, after) : ret;
	}
}
