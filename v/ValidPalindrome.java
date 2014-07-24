package v;

public class ValidPalindrome {
	 public boolean isPalindrome(String s) {
	       if(s.length()==0)return true;
	       
	       String str = s.toLowerCase();
	       
	       int start = 0;
	       int end = str.length()-1;
	       
	       while(start < end){
	    	   while((str.charAt(start)<'0'||(str.charAt(start)>'9' && str.charAt(start) < 'a')||str.charAt(start)>'z') && start < end){
	    		   start++;
	    	   }
	    	   while((str.charAt(end)<'0'||(str.charAt(end)>'9' && str.charAt(end) < 'a')||str.charAt(end)>'z')&& start < end){
	    		   end--;
	    	   }
	    	   if(start<end){
	    		   if(str.charAt(start)!=str.charAt(end)){
	    			   return false;
	    		   }
	    		   start++;
	    		   end --;
	    	   }
	       }
	       
	       return true; 
	    }
}
