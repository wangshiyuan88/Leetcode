package freq4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Anagrams {
//	Given an array of strings, return all groups of strings that are anagrams.
//	Note: All inputs will be in lower-case.
	
	public List<String> anagrams(String[] strs) {
		 List<String> set = new ArrayList<String>();
	     Map<String, String> map = new HashMap<String, String>();
	     for(String str : strs){
		    	 Map<Character, Integer> charNumber = new TreeMap<Character, Integer>();
		    	 StringBuilder fingerprint = new StringBuilder();
		    	 for(int i = 0; i < str.length(); i++){
		    		 if(!charNumber.containsKey(str.charAt(i)))
		    			 charNumber.put(str.charAt(i), 0);
		    		 charNumber.put(str.charAt(i), charNumber.get(str.charAt(i))+1);
		    	 }
		    	 for(Character c : charNumber.keySet()){
		    		 fingerprint.append(c+""+charNumber);
		    	 }
		    	 if(!map.containsKey(fingerprint.toString())){
		    		 map.put(fingerprint.toString(), str);
		    	 }else{
		    		if(!set.contains(map.get(fingerprint.toString())))
		    				set.add(map.get(fingerprint.toString()));
		    		set.add(str);
		    	 }
	     	}
		 return set;
	  }
}
