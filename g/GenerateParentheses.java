package g;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<String>();
		generateParenthesis(n, n, new StringBuilder(), ret);
		return ret;
    }

	private void generateParenthesis(int left, int right,
			StringBuilder sb, List<String> ret) {
		if(left==0&&right==0){
			ret.add(sb.toString());
		}
		if(right < left){
			return;
		}
		if(left>0){
			sb.append("(");
			generateParenthesis(left-1, right, sb, ret);
			sb.deleteCharAt(sb.length()-1);
		}
		if(right>0){
			sb.append(")");
			generateParenthesis(left, right-1, sb, ret);
			sb.deleteCharAt(sb.length()-1);
		}
	}

	public static void main(String args[]){
		new GenerateParentheses().generateParenthesis(1);
	}
}

