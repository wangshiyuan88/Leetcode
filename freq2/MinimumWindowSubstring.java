package freq2;

import java.util.HashMap;
import java.util.Map;


public class MinimumWindowSubstring {
//	public String minWindow(String S, String T) {
//        if(T.equals("")||S.length()<T.length())
//        	return "";
//        Map<Character,Integer> map = new HashMap<Character, Integer>();
//        for(int i = 0; i < T.length(); i++){
//        	if(!map.containsKey(T.charAt(i)))
//        		map.put(T.charAt(i), 0);
//        	map.put(T.charAt(i), map.get(T.charAt(i))+1);
//        }
//		int charToMatch = map.size();
//		int start = 0;
//		int end = -1;
//		int windowLength = Integer.MAX_VALUE;
//		String minWindows = "";
//		while(true){
//			if(charToMatch==0){
//				if(windowLength>end-start+1){
//					minWindows = S.substring(start, end+1);
//					windowLength = minWindows.length();
//				}
//				if(map.containsKey(S.charAt(start))){
//					int n = map.get(S.charAt(start));
//					if(n==0)
//						charToMatch++;
//					map.put(S.charAt(start), n+1);
//				}
//				start++;
//			}
//			else{
//				end++;
//				if(end==S.length())
//					break;
//				if(map.containsKey(S.charAt(end))){
//					int n = map.get(S.charAt(end));
//					if(n==1)
//						charToMatch--;
//					map.put(S.charAt(end), n-1);
//				}
//			}
//		}
//		return minWindows;
//    }
	
	public String minWindow(String S, String T) {
        if(T.equals("")||S.length()<T.length())
        	return "";
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < T.length(); i++){
        	if(!map.containsKey(T.charAt(i)))
        		map.put(T.charAt(i), 0);
        	map.put(T.charAt(i), map.get(T.charAt(i))+1);
        }
		int charToMatch = map.size();
		int start = 0;
		int end = 0;
		int windowLength = Integer.MAX_VALUE;
		String minWindows = "";
		while(end<S.length()){
			if(map.containsKey(S.charAt(end))){
				int n = map.get(S.charAt(end));
				if(n==1)
					charToMatch--;
				map.put(S.charAt(end), n-1);
			}
			while(charToMatch==0){
				if(windowLength>end-start+1){
					minWindows = S.substring(start, end+1);
					windowLength = minWindows.length();
				}
				if(map.containsKey(S.charAt(start))){
					int n = map.get(S.charAt(start));
					if(n==0)
						charToMatch++;
					map.put(S.charAt(start), n+1);
				}
				start++;
			}
			end++;
		}
		return minWindows;
    }
	
	 public static void main(String args[]){
		System.out.println( new MinimumWindowSubstring().minWindow("caccaacaaaabbcaccaccc", "acccacbccc"));
	 }
}
