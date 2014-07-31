package c;

import java.util.HashMap;
import java.util.Map;

import common.UndirectedGraphNode;

public class CloneGraph {
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
			if(node==null)
				return null;
			Map<Integer, UndirectedGraphNode> labelNode = new HashMap<Integer, UndirectedGraphNode>();
			return cloneNode(node, labelNode);
	    }

		private UndirectedGraphNode cloneNode(UndirectedGraphNode node,
				Map<Integer, UndirectedGraphNode> labelNode) {
			if(labelNode.containsKey(node.label))
				return labelNode.get(node.label);
			
			UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
			labelNode.put(newNode.label, newNode);
			for(UndirectedGraphNode neighbourToClone : node.neighbors){
				UndirectedGraphNode clonedNeighbour = cloneNode(neighbourToClone, labelNode);
				newNode.neighbors.add(clonedNeighbour);
			}
			return newNode;
		}
}
