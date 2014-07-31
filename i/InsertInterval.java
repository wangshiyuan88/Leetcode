package i;

import java.util.ArrayList;
import java.util.List;

import common.Interval;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> ret = new ArrayList<Interval>();
		Interval temp = newInterval;
		for(Interval i : intervals){
			if(i.end<temp.start){
				ret.add(i);
			}else if(i.start > temp.end){
				ret.add(temp);
				temp = i;
			}else{
				temp = new Interval(Math.min(temp.start, i.start), Math.max(temp.end, i.end));
			}
		}
		ret.add(temp);
		return ret;
    }
}
