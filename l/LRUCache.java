package l;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
		int size = 0;
		int capacity = 0;
		DoubleLinkedListNode head;
		DoubleLinkedListNode end;
		public class DoubleLinkedListNode{
			public int val;
			public int key;
			public DoubleLinkedListNode before;
			public DoubleLinkedListNode after;
			public DoubleLinkedListNode(){
				val = 0;
				key = 0;
			}
			public DoubleLinkedListNode(int key, int val){
				this.val = val;
				this.key = key;
			}
		}
		Map<Integer, DoubleLinkedListNode> map;
		public LRUCache(int capacity) {
	        this.capacity = capacity;
	        map = new HashMap<Integer, DoubleLinkedListNode>();
	    }
	    
	    public int get(int key) {
	    	if(map.containsKey(key)){
	    		DoubleLinkedListNode node = map.get(key);
	    		detach(node);
	    		moveToHead(node);
	    		return node.val;
	    	}
	    	else	
	    		return -1;   
	    }
	    
	    private void moveToHead(DoubleLinkedListNode node) {
			head.before = node;
			node.after = head;
			head = node;
		}

		private void detach(DoubleLinkedListNode node) {
			if(node!=head){
				node.before.after = node.after;
			}
			if(node!=end){
				node.after.before = node.before;
			}else{
				end = node.before==null? node : node.before;
			}
			node.before = null;
			node.after = null;
		}

		public void set(int key, int value) {
	        if(map.containsKey(key)){
	        	DoubleLinkedListNode node = map.get(key);
	        	node.val = value;
	        	if(node!=head){
	        		detach(node);
	        		moveToHead(node);
	        	}
	        }else{
	        	DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
	        	map.put(key, node);
	        	if(head == null){
	        		head = node;
	        		end = node;
	        	}
	        	else
	        		moveToHead(node);
	        	if(map.size()>capacity){
	        		map.remove(end.key);
	        		DoubleLinkedListNode beforeEnd = end.before;
	        		beforeEnd.after = null;
	        		end.before = null;
	        		end = beforeEnd;
	        	}
	        }
	    }
		
		public static void main(String args[]){
			LRUCache cache = new LRUCache(2);
			cache.get(2);
			cache.set(2, 6);
		//	cache.set(1, 1);
			cache.get(1);
			cache.set(1, 5);
			cache.set(1, 2);
			cache.get(1);
			cache.get(2);
		}
}
