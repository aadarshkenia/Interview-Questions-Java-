import java.util.*;
class _56 {

	public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        PriorityQueue<Interval> pq = new PriorityQueue<>(n, (i1, i2) -> {
        	if(i1.start != i2.start) return i1.start - i2.start;
        	else return i1.end - i2.end;
        });

        for(Interval interval : intervals) {
        	pq.add(interval);
        } 

        List<Interval> answer = new ArrayList<>();
       	Interval current = pq.poll();
       	while(pq.size() > 0) {
       		Interval next = pq.poll();
       		if(canMerge(current, next)) {
       			//Update end of current
       			current.end = Math.max(current.end, next.end);
       		} else {
       			answer.add(current);
       			current = next;
       		}
       	}
       	return answer;
    }

    private boolean canMerge(Interval i1, Interval i2) {
    	if(i2.start > i1.end || i2.end < i1.start) return false;
    	return true;
    }

}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}