package freq5;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
//		Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
//
//		Only one letter can be changed at a time
//		Each intermediate word must exist in the dictionary
//		For example,
//		Given:
//		start = "hit"
//		end = "cog"
//		dict = ["hot","dot","dog","lot","log"]
//		As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//		return its length 5.
	
//	Note:
//		Return 0 if there is no such transformation sequence.
//		All words have the same length.
//		All words contain only lowercase alphabetic characters
	
	public int ladderLength(String start, String end, Set<String> dict) {
        
		Queue<String> current = new LinkedList<String>();
		Queue<String> next = new LinkedList<String>();
		current.add(start);
		dict.remove(current);
		int ladderLength = 0;
		while(!current.isEmpty()){
			String currentString = current.poll();
			if(currentString.equals(end))
				return ladderLength;
			for(int i = 0; i < start.length(); i++){
				char[] charArray = currentString.toCharArray();
				for(char c = 'a'; c <= 'z'; c++){
					charArray[i] = c;
					String temp = new String(charArray);
					if(dict.contains(temp)){
						next.add(temp);
						dict.remove(temp);
					}
				}
			}	
			if(current.isEmpty()){
				current = next;
				ladderLength++;
			}
		}
		
		return 0;
    }
	
	 public static void main(String args[]){
		 Set<String> set = new HashSet<String>();
		 set.add("a");
		 set.add("b");
		 set.add("c");
		 new WordLadder().ladderLength("a", "c", set);
	 }
}
