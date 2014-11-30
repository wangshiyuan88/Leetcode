package freq3;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<Integer>();
		for(int number : num){
			set.add(number);
		}
		int max = 0;
		for(int number : num){
			if(set.contains(number)){
				int left = number-1;
				int right = number+1;
				set.remove(number);
				while(set.contains(left))
					set.remove(left--);
				while(set.contains(right))
					set.remove(right++);
				max = Math.max(max, right-left-1);
			}
		}
		return max;
    }
}
