package freq5;

import java.util.List;

import common.Interval;

public class InsertInterval {
	 public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		 int index = 0;
		 while(index<intervals.size()){
			 Interval current = intervals.get(index);
			 if(current.end < newInterval.start){
				 index++;
				 continue;
			 }
			newInterval.start = newInterval.start < current.start? newInterval.start : current.start;
			if(newInterval.end < current.start){
				intervals.add(index, newInterval);
				break;
			}	
			if(newInterval.end >= current.end ){
				intervals.remove(current);
			}else{
				current.start = newInterval.start;
				break;
			}
		 }
		 if(index == intervals.size()){
			 intervals.add(newInterval);
		 }
		 return intervals; 
	 }
}
