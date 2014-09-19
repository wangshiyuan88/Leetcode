package r;

public class RegularExpressionMatching {
	  public boolean isMatch(String s, String p) {
		  if(s.length()==0){
			  return p.length()==0;
		  }
		  if(p.length()==0)
			  return false;
		  if(p.length() == 1 ||(p.length()>1&&p.charAt(1)!='*')){
			  if(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.'){
				  return isMatch(s.substring(1), p.substring(1));
			  }
			  else
				  return false;
		  }
		  else{
			  int start = -1;
			  while(start< s.length()&&(start < 0 || p.charAt(0) == '.' || s.charAt(start) == p.charAt(0))){
				  if(isMatch(s.substring(start+1), p.substring(2))){
					  return true;
				  }
				  start++;
			  }
		  }
		  return false;
	  }
	  
	  public  static void main(String []args){
		  System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
	  }
}
