package freq2;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s==null||s.length()==0)
			return 0;
		Set<Character> set = new HashSet<Character>();
		set.add(s.charAt(0));
		int max = 0;
		for(int current = 1, before = 0; current < s.length(); current++){
			char c = s.charAt(current);
			if(!set.contains(c)){
				set.add(c);
				max = Math.max(set.size(), max);
			}else{
				while(s.charAt(before)!=c){
					set.remove(s.charAt(before));
					before++;
				}
			}
		}
		return max>set.size()? max : set.size();
    }
}
