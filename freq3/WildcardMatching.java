package freq3;

public class WildcardMatching {
	 
	
//	'?' Matches any single character.
//	'*' Matches any sequence of characters (including the empty sequence).
//	The matching should cover the entire input string (not partial).
//	The function prototype should be:
//	bool isMatch(const char *s, const char *p)
//	Some examples:
//	isMatch("aa","a") ¡ú false
//	isMatch("aa","aa") ¡ú true
//	isMatch("aaa","aa") ¡ú false
//	isMatch("aa", "*") ¡ú true
//	isMatch("aa", "a*") ¡ú true
//	isMatch("ab", "?*") ¡ú true
//	isMatch("aab", "c*a*b") ¡ú false
	
	public boolean isMatch(String s, String p) {
		int pres = -1;
		int prep = -1;
		int si = 0; 
		int pi = 0;
		boolean star = false;
		
		while(si<s.length()){
			if(pi<p.length()&&p.charAt(pi)=='*'){
				star = true;
				pres = si;
				while(pi<p.length()&&p.charAt(pi)=='*')
					pi++;
				if(pi==p.length())
					return true;
				prep = pi;
			}else{
				if(pi<p.length()&&(p.charAt(pi)=='?'||p.charAt(pi)==s.charAt(si))){
					pi++;
					si++;
				}else{
					if(star){
						pi = prep;
						pres++;
						si = pres;
					}
					else 	
						return false;
				}
			}
		}
		
		while(pi<p.length()&&p.charAt(pi)=='*')
			pi++;
		
		return pi == p.length();
	}
	
	public static void main(String[] args){
		System.out.println(new WildcardMatching().isMatch("hi", "*?"));
	}
}
