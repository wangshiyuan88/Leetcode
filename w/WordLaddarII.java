package w;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLaddarII {
 public List<List<String>> findLadders(String start, String end, Set<String> dict) {
	 List<List<String>> ret = new ArrayList<List<String>>();      
	 Map<String, Set<String>> retrackMap = new HashMap<String, Set<String>>();
	 Queue<String> cq = new LinkedList<String>();
	 Queue<String> nq = new LinkedList<String>();
	 Set<String> visited = new HashSet<String>();
	 cq.add(start);
	 while(!cq.isEmpty()){
		 String current = cq.poll();
		 if(current.equals(end)){
			  List<String> list = new LinkedList<String>();
			  list.add(end);
			  generateOutput(end, retrackMap, ret, list);
			  return ret;
		 }
		 visited.add(current);
		 generateNextWords(cq, nq, visited, retrackMap, current, dict);
		 if(cq.isEmpty()){
			 cq = nq;
			 nq = new LinkedList<String>() ;
		 }
	 }
	 return ret;
	 }

	private void generateNextWords(Queue<String> cq, Queue<String> nq, Set<String> visited,
			Map<String, Set<String>> retrackMap, String current, Set<String> dict) {
		for(int i = 0; i < current.length(); i++){
			for(char c = 'a'; c < 'z'; c++){
				char[] charArray = current.toCharArray();
				charArray[i] = c;
				String temp = new String(charArray);
				if(dict.contains(new String(charArray))&&!visited.contains(temp)&&!cq.contains(temp)){
					if(!nq.contains(temp))
						nq.add(temp);
					if(retrackMap.get(temp)==null)
						retrackMap.put(temp, new HashSet<String>());
					retrackMap.get(temp).add(current);
				}
			}
		}
		
	}

	private void generateOutput(String current, Map<String, Set<String>> retrackMap, List<List<String>> ret, List<String> track) {
		if(retrackMap.get(current)==null){
			ret.add(new LinkedList<String>(track));
			return;
		}
		for(String s : retrackMap.get(current)){
			track.add(0,s);
			generateOutput(s, retrackMap, ret, track);
			track.remove(0);
		}
	}
	
	public static void main(String args[]){
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dog");
		set.add("cog");
		set.add("tot");
		set.add("hog");
		set.add("hop");
		set.add("dot");
		System.out.println(new WordLaddarII().findLadders("hot", "dog", set));
	}
}
