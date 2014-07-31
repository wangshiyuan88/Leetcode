package l;

public class LongestCommonPrefix {
	 public String longestCommonPrefix(String[] strs) {
		 if(strs==null||strs.length<=0)
	    	 return "";
	     String commonPrefix = strs[0];
	     
	     for(int i = 1; i < strs.length; i++){
	    	 commonPrefix = strs[i].length() < commonPrefix.length()? commonPrefix.substring(0,  strs[i].length()): commonPrefix; 
	    	 for(int j = 0; j < strs[i].length()&&j < commonPrefix.length(); j++){
	    		 if(commonPrefix.charAt(j)!= strs[i].charAt(j)){
	    			 commonPrefix = commonPrefix.substring(0, j);
	    		 }
	    	 }
	     }
		 
		 return commonPrefix;
	 }
	 
	 public static void main(String args[]){
		 String i = "ABCD";
		 i = i.substring(0,0);
		 System.out.println(i);
		 new LongestCommonPrefix().longestCommonPrefix(new String[]{"A", "B"});
	 }
}
