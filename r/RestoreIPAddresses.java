package r;

import java.util.ArrayList;
import java.util.List;



public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
	    List<String> ret = new ArrayList<String>(); 
		if(s == null||s.length() < 4)
	    	  return ret;
		restoreIpAddress(s, 1, "", ret);
		return ret;
	  }
	private void restoreIpAddress(String remainString, int partNumber, String currentIP,
			List<String> ret) {
		if(partNumber > 4 && remainString.equals("")){
			
			ret.add(currentIP.substring(0, currentIP.length()-1));
			return;
		}
		
		if((remainString.length() < 4- partNumber +1)||(remainString.length()> (5-partNumber)*3)){
			return;
		}
		
		for(int i = 0; (i < 3&& i< remainString.length());i++){
			
			String ip = remainString.substring(0, i+1);
			
			if(Integer.parseInt(ip)<=255){
				restoreIpAddress(remainString.substring(i+1), partNumber+1, currentIP+ip+".",ret);
			}
		
			if(Integer.parseInt(ip)==0)
				break;
		}
	}
	
	public static void main(String args[]){
		new RestoreIPAddresses().restoreIpAddresses("0000");
		
	}
}
