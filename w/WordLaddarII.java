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
	 Map<String, List<String>> retrackMap = new HashMap<String, List<String>>();
	 Queue<String> cq = new LinkedList<String>();
	 Set<String> visited = new HashSet<String>();
	 cq.add(start);
	 while(!cq.isEmpty()){
		 Queue<String> next = new LinkedList<String>();
		 visited.add(current);
		 while(!cq.isEmpty()){
			 
		 }
	 }
	 
	 return ret;
	 }
}
