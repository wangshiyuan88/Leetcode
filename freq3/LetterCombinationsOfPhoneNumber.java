package freq3;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
	char[][] map = new char[][]{
			{}, {}, {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},
			{'t','u','v'},{'w','x','y','z'}
		};
	public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        ret.add("");
        for(int i = 0; i < digits.length();i++){
        	int index = digits.charAt(i) - '0';
        	List<String> temp = new ArrayList<String>();
        	for(char c: map[index]){
        		for(String s : ret){
        			temp.add(s+c);
        		}
        	}
        	ret = temp;
        }
		return ret;
    }
}
