package freq4;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
//	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//	For example, given n = 3, a solution set is:
//	"((()))", "(()())", "(())()", "()(())", "()()()"
	
	public List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<String>();
		generateParenthesis(n, n, new StringBuilder(), ret);
		return ret;
    }

	private void generateParenthesis(int left, int right,
			StringBuilder sb, List<String> ret) {
		if(left>right)
			return;
		if(right==0){
			ret.add(sb.toString());
			return;
		}
		if(left>0){
			sb.append("(");
			generateParenthesis(left-1, right, sb, ret);
			sb.deleteCharAt(sb.length()-1);
		}
			sb.append(")");
			generateParenthesis(left, right-1, sb, ret);
			sb.deleteCharAt(sb.length()-1);
	}
}
