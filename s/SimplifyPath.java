package s;

import java.util.Stack;

public class SimplifyPath {
	 public String simplifyPath(String path) {
			String[] tokenizer = path.split("/");
			Stack<String> dirStack = new Stack<String>();
			for(String current : tokenizer){
				if(current.equals("..")){
					if(!dirStack.isEmpty()){
						dirStack.pop();
					}
				}else if(!current.equals("")&&!current.equals(".")){
					dirStack.push(current);
				}
			}
			
			if(dirStack.isEmpty())
				return "/";
			
			StringBuilder ret = new StringBuilder();
			for(String dir : dirStack){
				ret.append("/"+dir);
			}
			
			return ret.toString();
	    }
	
	public static void main(String args[]){
		new SimplifyPath().simplifyPath(null);
	}
}
