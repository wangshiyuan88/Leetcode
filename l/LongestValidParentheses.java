package l;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int leftLimit = -1;
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i)=='('){
        		stack.push(i);
        	}else{
        		if(stack.isEmpty()){
        			leftLimit = i;
        		}else{
        			stack.pop();
        			if(stack.isEmpty())
        				max = Math.max(i - leftLimit, max);
        			else
        				max = Math.max(i - stack.peek(), max);
        		}
        	}
        }
		return max;
    }
}
