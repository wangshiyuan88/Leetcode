package w;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLaddar {
	 public int ladderLength(String start, String end, Set<String> dict) {
	 
		 Queue<Integer> distanceQueue = new LinkedList<Integer>();
		 Queue<String> wordQueue = new LinkedList<String>();
		 
		 distanceQueue.add(0);
		 wordQueue.add(start);
		 
		 while(!wordQueue.isEmpty()){
			 	int currentDistance = distanceQueue.poll();
			 	String currentWord = wordQueue.poll();
			 	if(currentWord.equals(end)){
			 		return currentDistance;
			 	}
			 	
			 	for(int i = 0; i < currentWord.length(); i++){
			 		char[] currentCharArray = currentWord.toCharArray();
			 	
			 		for(char c = 'a'; c <='z' ; c++){
			 			
			 				currentCharArray[i] = c;
			 				String newWord = new String(currentCharArray);
			 				if(dict.contains(newWord)){
			 					distanceQueue.add(currentDistance+1);
			 					wordQueue.add(newWord);
			 					dict.remove(currentWord);
			 				}
			 			
			 		}
			 	}
		 }
		 
		 return 0;
	 }
}
