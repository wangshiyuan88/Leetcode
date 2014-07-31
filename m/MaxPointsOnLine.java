package m;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {
	public int maxPoints(Point[] points){
		Map<Float, Integer> linePointCountMap = new HashMap<Float, Integer>(); 
		int max = 0;
		for(int i = 0; i < points.length; i++){
			Point current = points[i];
			linePointCountMap.clear();
			int same = 0;
			for(int j = 0; j < points.length; j++){
				if(i==j) continue;
				
				if(current.x == points[j].x && current.y == points[j].y){
					same++;
					continue;
				}
				else{
					float slope = Integer.MIN_VALUE;
					if(current.x == points[j].x){
						slope = Integer.MAX_VALUE;
					}else{
						slope = ((float)(current.y - points[j].y))/(current.x - points[j].x); //be careful about casting the numerator to float
					}
					if(!linePointCountMap.containsKey(slope)){
						linePointCountMap.put(slope, 2);
					}else{
						linePointCountMap.put(slope, linePointCountMap.get(slope)+1);
					}
				}
			}
			
			for(float k : linePointCountMap.keySet()){
				max = Math.max(linePointCountMap.get(k)+same, max);
			}
			max = Math.max(max, same+1);
		}
		
		return max;
	}
}
