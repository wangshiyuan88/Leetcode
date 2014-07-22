package v;

import java.util.LinkedList;

public class ValidParentheses {
	public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        LinkedList<Character> stack = new LinkedList<Character>();
        for(char c : s.toCharArray()){
        	if(c == '('|| c== '{'|| c=='['){
        		stack.push(c);
        	}else if(stack.isEmpty()){
        		return false;
        	}else{
        		switch(c){
    			case ')':{
    				if(stack.pop()!='(')
    					return false;
    				break;
    			}
    			case '}':{
    				if(stack.pop()!='{')
    					return false;
    				break;
    			}
    			case ']':{
    				if(stack.pop()!='[')
    					return false;
    				break;
    			}
    			default: 
    				return false;
        		}
        	}
        }
        System.out.println("!");
		return stack.isEmpty();
    }
}
