package l;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithougRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int before = 0;
		int end = 0;
		int max = 0;
		if(s.length()<=1){
			return s.length();
		}
		Set<Character> charSet = new HashSet<Character>();
		while (end < s.length()) {
			char current = s.charAt(end);
			if (!charSet.contains(current)) {
				end++;
				charSet.add(current);
			} else {
				max = Math.max(max, end - before);
				while (charSet.contains(current)) {
					charSet.remove(s.charAt(before++));
				}
			}
		}
		
		return Math.max(max, end-before);
	}
	
	public static void main(String args[]){
		new LongestSubstringWithougRepeatingCharacters().lengthOfLongestSubstring("hchzvfrkmlnozjk");
	}
}
