import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class MergeIntervals{
	public static void main(String args[]){
		Interval i1 = new Interval(4,5);
		Interval i2 = new Interval(1,4);
		Interval i3 = new Interval(0, 1);
		//Interval i4 = new Interval(18, 20);

		List<Interval> input = new ArrayList();
		input.add(i1);
		input.add(i2);
		input.add(i3);
		//input.add(i4);

		System.out.println(merge(input));
	}

	//Modified for Insert Intervals problem



	public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
		HashMap<Integer, Interval> timeline = new HashMap();
		int globalStart=0, globalEnd=0;
		if(intervals.size() < 1){
			globalStart = newInterval.start;
			globalEnd = newInterval.end;
			mapRange(globalStart, globalEnd, newInterval, timeline);
			return intervalsFromTimeline(timeline, globalStart, globalEnd);	
		}
		globalStart=intervals.get(0).start;
		globalEnd=intervals.get(0).end;
		
		for(Interval interval : intervals){
			mapRange(interval.start, interval.end, interval, timeline);
			globalEnd = interval.end;
		}

		//Add the new interval
		int s = interval.start;
		int e = interval.end;
	
		Interval startInt = (Interval)timeline.get(s);
		Interval endInt = (Interval)timeline.get(e);

		if(startInt == null && endInt == null){
			
			if(globalStart > s)
				globalStart = s;
			if(globalEnd < e)
				globalEnd = e;

			mapRange(s, e, interval, timeline);
		}
		else if(startInt == endInt){
			//Dont do anything

		}
		else{
			if(startInt == null){
				if(globalStart > s)
					globalStart = s;
				
				mapRange(s, endInt.start-1, endInt, timeline);
				endInt.start = s;
			}
			else if(endInt == null){
				if(globalEnd < e)
					globalEnd = e;
				
				mapRange(startInt.end+1, e, startInt, timeline);
				startInt.end = e;
			}
			else{
				Interval newTempInterval = new Interval(startInt.start, endInt.end);
				mapRange(startInt.start, endInt.end, newTempInterval, timeline);
			}
		}	

		return intervalsFromTimeline(timeline, globalStart, globalEnd);
	}//end of insert()

	//Method to map a given range to timeline with an interval obj
	private static void mapRange(int s, int e, Interval obj, HashMap<Integer, Interval> map){
		for(int i=s; i <= e; i++){
			map.put(i, obj);
		}
	}

	private static List<Interval> intervalsFromTimeline(HashMap<Integer, Interval> map, int globalStart, int globalEnd){
		List<Interval> output = new ArrayList();
		int i = globalStart;
		while(i <= globalEnd){
			if(map.containsKey(i)){
				Interval current = (Interval)map.get(i);
				output.add(current);
				i = current.end+1; 
			}
			else
				i++;
			
		}
		return output;
	}
}

class Interval{
	int start;
	int end;

	Interval(){start=0; end=0;}
	Interval(int s, int e){start=s; end=e;}
	
	public String toString(){
		String s = "Start: "+start+" End: "+end;
		return s;
	}
}
