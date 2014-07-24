package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
	 
	public static ArrayList<String> anagrams(String[] strs) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        ArrayList<String> result = new ArrayList<String>();
	        if(strs.length<2){
	            return result;
	        }
	        Map<String, Integer> map = new HashMap<String, Integer>();
	        String temp = null;
	        for(int i = 0; i < strs.length; i++){
	            char[] charArray = strs[i].toCharArray();
	            Arrays.sort(charArray);
	            temp = new String(charArray);
	            if(map.containsKey(temp)){
	                if(map.get(temp)>=0){
	                    result.add(strs[map.get(temp)]);
	                    map.put(temp, -1);
	                }
	                result.add(strs[i]);
	            }else{
	                map.put(temp,i);
	            }
	        }
	        return result;
	    }
}
