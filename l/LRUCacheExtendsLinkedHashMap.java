package l;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheExtendsLinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public LRUCacheExtendsLinkedHashMap(int capacity) {
        super(16,0.75f,true);
    }
    
    public int get(int key) {
        Integer v = super.get(key);
        if(v != null)
        	return v;
        else 
        	return -1;
    }
    
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
		return size()>capacity;
    	
    }
    public void set(int key, int value) {
        super.put(key, value);
    }
}