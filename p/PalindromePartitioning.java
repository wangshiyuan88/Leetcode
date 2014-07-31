package p;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePartitioning {
	 public List<List<String>> partition(String s) {
	     List<List<String>> ret = new ArrayList<List<String>>();   
	     Set<String> palindromeString = new HashSet<String>();
	     
	     
		 partition(s, 0, new ArrayList<String>(), ret, palindromeString);
		 return ret;
	 }

	private void partition(String s, int start, ArrayList<String> arrayList,
			List<List<String>> ret, Set<String> palindromeString) {
		if(start == s.length()){
			ret.add(new ArrayList(arrayList));
			return;
		}
		
		for(int i = start+1; i <= s.length(); i++){
			String current = s.substring(start, i);
			if(isPalindrome(current, palindromeString)){
				arrayList.add(current);
				partition(s, i, arrayList, ret, palindromeString);
				arrayList.remove(arrayList.size()-1);
			}
		}
	}

	private boolean isPalindrome(String current, Set<String> palindromeString ) {
		if(palindromeString.contains(current))
			return true;
		int start = 0;
		int end = current.length()-1;
		while(start <= end){
			if(current.charAt(start++)!=current.charAt(end--))
				return false;
		}
		palindromeString.add(current);
		return true;
	}
	
	public static void main(String args[]){
		new PalindromePartitioning().partition("a");
	}

}
