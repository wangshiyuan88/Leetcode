package e;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	 public int evalRPN(String[] tokens) {
	 Stack<Integer> stack = new Stack<Integer>();
	 for(int i = 0; i < tokens.length; i++){
		if(tokens[i].equals("+")){
			stack.push(stack.pop()+stack.pop());
		}else if(tokens[i].equals("-")){
			int first = stack.pop();
			stack.push(stack.pop()-first);
		}else if(tokens[i].equals("*")){
			stack.push(stack.pop()*stack.pop());
		}else if(tokens[i].equals("/")){
			int first = stack.pop();
			stack.push(stack.pop()/first);
		}else{
			stack.push(Integer.parseInt(tokens[i]));
		}
	 }
	 return stack.peek();
	 }
}
