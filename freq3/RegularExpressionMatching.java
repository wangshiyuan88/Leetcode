package freq3;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if(s.length()==0&&p.length()==0)
			return true;
		   
		if(p.length()==0)
			return false;
			
		if(p.length()==1||p.charAt(1)!='*'){
			if(s.length()==0||(p.charAt(0)!='.'&&p.charAt(0)!=s.charAt(0)))
				return false;
			else
				return isMatch(s.substring(1),p.substring(1));
		}
		
		int start = 0;
		while(start<s.length()&&(s.charAt(start)==p.charAt(0)||p.charAt(0)=='.')){
			if(isMatch(s.substring(start), p.substring(2)))
				return true;
			start++;
		}
		
		return isMatch(s.substring(start),p.substring(2));
    }

}
