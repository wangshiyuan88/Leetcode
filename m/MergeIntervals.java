package m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.Interval;


public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals){

		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval a, Interval b){
				return a.start>b.start?1:(a.start==b.start?0:-1);}
			});
		
		if(intervals==null||intervals.size()<=1){
			return intervals;
		}
	
		int end = intervals.get(0).end;
		for(int i = 1; i < intervals.size();){
			Interval current = intervals.get(i);
			if(end<current.start){
				end = current.end;
				i++;
				continue;
			}
			if(end<=current.end){
				intervals.remove(current);
				intervals.get(i-1).end = current.end > end? current.end : end;
				end = intervals.get(i-1).end;
			}else{
				intervals.remove(current);
			}
		}
		
		return intervals;
	}
	
	public static void main(String[] args){
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1,4));
		list.add(new Interval(0,2));
		list.add(new Interval(3,5));
		new MergeIntervals().merge(list);
	}
}
