package l;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : num){
        	set.add(i);
        }
        int max = 0;
        for(int i : num){
        	if(set.contains(i)){
	        	int left = i-1;
	        	int right = i+1;
	        	set.remove(num);
	        	while(set.contains(left)){
	        	    set.remove(left);
	        	    left--;
	        	}
	        	while(set.contains(right)){
	        	    set.remove(right);
	        	    right++;
	        	}
	        	max = Math.max(max, right-left-1);
        	}
        }
		return max;
    }
	
	public static void main(String args[]){
		new LongestConsecutiveSequence().longestConsecutive(new int[]{0});
	}
}
