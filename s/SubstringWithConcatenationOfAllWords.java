package s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	 public ArrayList<Integer> findSubstring(String S, String[] L) {
		 S = "barfoothefoobarman";
		 L = new String[]{"foo","bar"};
		 ArrayList<Integer> ret = new ArrayList<Integer>();
		 if(S==null||L==null||L.length==0)
	    	 return null;
	    
		 int numOfWords = L.length;
		 int wordLength = L[0].length();
	   
		 Map<String, Integer> wordsCountMap = new HashMap<String, Integer>();
	     for(int i = 0 ; i < L.length; i++){
	    	 if(!wordsCountMap.containsKey(L[i])){
	    		 wordsCountMap.put(L[i], 0);
	    	 }
	    	 wordsCountMap.put(L[i], wordsCountMap.get(L[i])+1);
	     }
		 
		 for(int i = 0; i < S.length()-numOfWords*wordLength+1; i++){
			 Map<String, Integer> tempWordRecord = new HashMap<String, Integer>(wordsCountMap);
			 String strToMatch = S.substring(i, i+numOfWords*wordLength);
			 for(int j = 0; j < strToMatch.length(); j+=wordLength){
				 String str = strToMatch.substring(j, j+wordLength);
				 if(!tempWordRecord.containsKey(str)||tempWordRecord.get(str)==0){
					 break;
				 }
				 tempWordRecord.put(str, tempWordRecord.get(str)-1);
				 if((j+wordLength)==strToMatch.length())
					 ret.add(i);
			 }
		 }   
		 return ret;   
	    }
}
