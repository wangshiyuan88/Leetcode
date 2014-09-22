package freq4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {
	 public List<List<String>> partition(String s) {
	       List<List<String>> ret = new ArrayList<List<String>>();
	       partition(s, 0, s.length()-1, new ArrayList<String>(), ret, new HashMap<String, Boolean>());
	       return ret;
	 }
	 
	 private void partition(String s, int start, int end, ArrayList<String> list, List<List<String>> ret, Map<String, Boolean> dp) {
		if(start>end){
			ret.add(new ArrayList<String>(list));
			return;
		}
		
		for(int i = start; i <=end; i++){
			if(iPalidrom(s, start, i, dp)){
				list.add(s.substring(start,i+1));
				partition(s, i+1, end, list, ret, dp);
				list.remove(list.size()-1);
			}
		}
		
	}

	private boolean iPalidrom(String str, int start, int end, Map<String, Boolean> dp){
		if(dp.containsKey(str.substring(start, end+1)))
			return dp.get(str);
		while(start<end){
			if(str.charAt(start)!=str.charAt(end)){
				dp.put(str.substring(start, end+1), false);
				return false;
			}
			start++;
			end--;
		}
		dp.put(str.substring(start, end+1), true);
		return true;
	 }
}
