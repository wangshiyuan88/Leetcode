package i;

public class Implement_strStr {
	 public String strStr(String haystack, String needle) {
	     if(haystack==null||haystack.length()==0){
	    	 return null;
	     }
	     if(needle==null||needle.length()==0){
	    	 return haystack;
	     }
	     int[] map = forKMPMap(needle);
	     
	     int p1 = 0;
	     int p2 = 0;
	     while(p1<haystack.length()){
	    	if(haystack.charAt(p1)==needle.charAt(p2)){
	    		p1++;
	    		p2++;
	    		if(p2 == needle.length())
	    			return haystack.substring(p1-p2);
	    	}
	    	else{
	    		if(p2>0){
	    			p2 = map[p2-1];
	    		}else{
	    			p1++;
	    		}
	    	}
	     }
		 return null;
	 }
	 
	 public int[] forKMPMap(String needle){
		 int[] ret = new int[needle.length()];
		 
		 int head = 0;
		 int current = 1;
		 int counter = 0;
		 while(current<needle.length()){
			 if(needle.charAt(current)==needle.charAt(head)){
				 ret[current] = ++counter;
				 head++;
				 current++;
			 }else{
				 if(head==0){
					 ret[current] = 0;
					 current++;
				 }
				 counter = 0;
				 head = 0;
			 }
		 }
		 return ret;
	 }
	 
	 public static void main(String args[]){
		 new Implement_strStr().strStr("aaa", "a");
		 
	 }
}
