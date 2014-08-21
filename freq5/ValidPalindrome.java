package freq5;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if(s.length()<=1)
        	return true;
        int start = 0;
        int end = s.length()-1;
        s  = s.toLowerCase();
        while(start<=end){
        	while(start<=end&&(s.charAt(start)>'z'||s.charAt(start)<'0'||(s.charAt(start)>'9'&&s.charAt(start)>'a')))
        		start++;
        	while(end>=start&&(s.charAt(end)>'z'||s.charAt(end)<'0'||(s.charAt(end)>'9'&&s.charAt(end)>'a')))
        		end--;
        	if(start>end)
        		return true;
        	if(s.charAt(start)!=s.charAt(end))
        		return false;
        	start++;
        	end--;
        }
		return true;
    }
}
