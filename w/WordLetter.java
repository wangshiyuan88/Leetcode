package w;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLetter {
	 public int ladderLength(String start, String end, HashSet<String> dict) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        HashSet<String> used = new HashSet<String>();
	        Queue<String> current = new LinkedList<String>();
	        if(start.equals(end)) return 0;
	        char[] temp;
	        int step = 1;
	        current.add(start);
	        while(!current.isEmpty()){
	        	Queue<String> next = new LinkedList<String>();
	        	for(String fromWord : current){
	        		if(fromWord.equals(end)){
	        			return step;
	        		}
	        		
	        		for(int i = 0 ; i < fromWord.length(); i++){
	        			temp = fromWord.toCharArray();
	        			for(char c = 'a'; c <= 'z' ; c++){
	        				temp[i] = c;
	        				String nextWord = new String(temp);
	        				if(nextWord.equals(end)){
	        					return step;
	        				}
	        				if(!used.contains(nextWord) && dict.contains(nextWord)){
	        					next.add(nextWord);
	        					used.add(nextWord);
	        				}
	        			}
	        		}
	        	}
	        	step++;
	        	current = next;
	        }       
	        return 0;
	    }
}
