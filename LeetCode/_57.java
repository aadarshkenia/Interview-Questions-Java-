import java.util.List;
import java.util.ArrayList;
class _57 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        //Do a binary search for insert position and merge
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
        	int mid = lo + (hi - lo)/2;
        	if(newInterval.start <= intervals.get(mid).start) {
        		if(mid > 0 && newInterval.start > intervals.get(mid - 1).start) {
        			break;
        		} else {//GO to left
        			hi = mid - 1;
        		}
        	} else {
        		lo = mid + 1;
        	}
        }
        int insertPosition = lo > hi ? lo : lo + (hi-lo) / 2;
        // System.out.println("Insert pos: " + insertPosition);
        int left = insertPosition;
        int right = insertPosition;
        int newStart = newInterval.start;
        int newEnd = newInterval.end;
        while(left > 0 && canMerge(intervals.get(left - 1), newInterval)) {
        	newStart = Math.min(newStart, intervals.get(left - 1).start);
        	left--;
        }
        while(right < n-1 && canMerge(intervals.get(right + 1), newInterval)) {
        	newEnd = Math.max(newEnd, intervals.get(right + 1).end);
        	right++;	
        }
        // System.out.println("Left:" + left + " right: "+right);
        //Update new interval
        newInterval.start = newStart;
        newInterval.end = newEnd;
        int i=0;
        List<Interval> answer = new ArrayList<>();
        while(i < n) {
        	if(i < left || i >= right) {
        		answer.add(intervals.get(i++));
        	} else {
        		answer.add(newInterval);
        		i = right;
        	} 
        }
        return answer;
    }    

    private boolean canMerge(Interval i1, Interval i2) {
    	if(i2.start > i1.end || i2.end < i1.start) return false;
    	return true;
    }
}