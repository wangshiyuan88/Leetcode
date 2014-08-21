package freq5;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import common.Interval;

public class MergeIntervals {

//	Given a collection of intervals, merge all overlapping intervals.
//
//	For example,
//	Given [1,3],[2,6],[8,10],[15,18],
//	return [1,6],[8,10],[15,18].
	
	public List<Interval> merge(List<Interval> intervals){
		if(intervals==null||intervals.size()<=1)
			return intervals;
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start==i2.start? i1.end - i2.end : i1.start - i2.start;
			}
			
		});
		Interval prev = intervals.get(0);
		List<Interval> ret = new LinkedList<Interval>();
		ret.add(prev);
		for(int i = 1; i < intervals.size();i++){
			Interval current = intervals.get(i);
			if(prev.end < current.start){
				ret.add(current);
				prev = current;;
			}
			else if(prev.end>=current.start&&prev.end<=current.end){
				prev.end = current.end;
			}
		}
		return ret;
	}
}
