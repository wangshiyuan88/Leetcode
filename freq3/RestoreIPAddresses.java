package freq3;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
//	Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//	For example:
//	Given "25525511135",
//
//	return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
//  The solution in the first try is more simple, need to review and learn more. 
	public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        restoreIpAddresses(s, 0, 0, new StringBuilder(),ret);
        return ret;
    }
	
	private void restoreIpAddresses(String s, int index, int part, StringBuilder sb, List<String>list){
		if(index==s.length()&&part==4){
			list.add(sb.toString().substring(1));
			return;
		}
		else if(index==s.length()||part==4)
			return;
		for(int i = index+1; i <= index+3&&i <= s.length(); i++){
			String current = s.substring(index, i);
			if((current.length()==1||!current.startsWith("0"))&&Integer.valueOf(current)<=255){
				sb.append("."+current);
				restoreIpAddresses(s, i, part+1, sb, list );
				sb.delete(sb.lastIndexOf("."), sb.length());
			}	
		}
	}
	
	public static void main(String args[]){
		new RestoreIPAddresses().restoreIpAddresses("0000");
	}
}
