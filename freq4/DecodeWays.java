package freq4;

public class DecodeWays {
//	Given an encoded message containing digits, determine the total number of ways to decode it.
//	For example,
//	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//	The number of ways decoding "12" is 2.
//	
	public int numDecodings(String s) {
        if(s==null||s.length()==1||s.startsWith("0"))
        	return 0;
        int pre1 = 1;
        int pre2 = 1;
        for(int i = 1; i < s.length(); i++){
        	int current = 0;
        	if(Integer.parseInt(s.substring(i-1,i+1))>=10&&Integer.parseInt(s.substring(i-1,i+1))<=26)
        		current += pre2;
        	current += s.charAt(i)=='0'? 0 : pre1;
        	pre2 = s.charAt(i)=='0'? 0 : pre1;
        	pre1 = current;
        }
		return pre1;
    }
}
