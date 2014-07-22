package w;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak1(String s, Set<String> dict) {
		if (s.length() == 0)
			return false;

		return breakHelper(s, dict, new HashMap<String, Boolean>());
	}

	private boolean breakHelper(String s, Set<String> dict,
			HashMap<String, Boolean> map) {

		if (map.containsKey(s)) {
			return map.get(s);
		}

		if (s == null || s.length() == 0 || dict.contains(s))
			return true;
		for (int i = 1; i < s.length(); i++) {
			if (dict.contains(s.substring(0, i))) {
				if (breakHelper(s.substring(i, s.length()), dict, map)) {
					map.put(s, true);
					return true;
				}
			}
		}
		map.put(s, false);
		return false;
	}

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		
		ArrayList<String> list = generateString(s, dict, new HashMap<String, ArrayList<String>>());
		
		return list == null? new ArrayList<String>() : list;
	}
	
	private ArrayList<String> generateString(String s, Set<String> dict, Map<String, ArrayList<String>> map){
		
		if(s.length()==0){
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}
		if(map.containsKey(s))
			return map.get(s);
		String current = null;
		ArrayList<String> answerForS = null;
		for(int i = 1; i <= s.length(); i++){
			current = s.substring(0, i);
			if(dict.contains(current)){
				ArrayList<String> afterWords = generateString(s.substring(i, s.length()), dict, map);
				if(afterWords!=null){
					
					if(answerForS == null){
						System.out.println(answerForS);
						answerForS = new ArrayList<String>();
					}
					for(String str : afterWords){
						answerForS.add((current + " " + str).trim());
					}
				}
			}
		}
	
		map.put(s, answerForS);
		return answerForS;
	}
}
