package freq5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

//	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//	The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

	public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<Character,Character>();
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
		int index = 0;
		while(index<s.length()){
			
			if(pairs.containsKey(s.charAt(index))){
				stack.push(s.charAt(index++));
			}else if(pairs.containsValue(s.charAt(index))){
				if(stack.isEmpty()||pairs.get(stack.pop())!=s.charAt(index++))
					return false;
			}else
				return false;
		}
        return stack.isEmpty();
    }
}
