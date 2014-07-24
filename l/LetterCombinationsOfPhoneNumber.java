package l;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

	char[][] map = new char[][]{
		{}, {}, {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},
		{'t','u','v'},{'w','x','y','z'}
	};
	
	  public List<String> letterCombinations(String digits) {
	      List<String> result = new ArrayList<String>();
	      if(digits==null){
	    	  return result;
	      }
		  buildCombinationList(0, digits, new StringBuilder(), result);
		  return result;
	  }

	private void buildCombinationList(int index, String digits,
			StringBuilder sb, List<String> result) {
		if(index==digits.length()){
			result.add(sb.toString());
			return;
		}
		
		for(int i = 0; i < map[digits.charAt(index)-'0'].length; i++){
			sb.append(map[digits.charAt(index)-'0'][i]);
			buildCombinationList(index+1, digits, sb, result);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
//	public static void main(String args[]){
//		new LetterCombinationsOfPhoneNumber().letterCombinations("2");
//	}
}
