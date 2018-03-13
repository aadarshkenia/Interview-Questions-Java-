class _154{
	public static void main(String[] args) {
			
	}

	public static int findMin(int[] x) {
        int n = x.length;
        int lo = 0, hi = n-1;
        while(lo <= hi){
        	if(lo == hi)
        		return x[lo];

        	int mid = lo + (hi-lo)/2;
        	if(mid != lo){
        		if(x[mid] < x[mid-1])
        			return x[mid];
        		else{
        			//Goto left side
        			if(x[mid] < x[hi]){
        				hi = mid-1;
        			}
        			else if(x[mid] == x[hi]){
        				if(x[mid] != x[lo])
        					hi = mid - 1;
        				else
        					lo = mid + 1;
        			}
        			else//Goto right side
        				lo = mid + 1;	
        		}
        	}
        	else
        		return Math.min(x[lo], x[hi]);
        }
    }

    public static int min(int[] x, int lo, int hi){
    	if(lo == hi)
    		return x[lo];

    	int mid = lo + (hi - lo)/2;
    	if(mid != lo){
    		if(x[mid] < x[mid-1])
        			return x[mid];
        		else{
        			//Goto left side
        			if(x[mid] < x[hi]){
        				return min(x, lo, mid-1);
        			}
        			else if(x[mid] == x[hi]){
        				if(x[mid] != x[lo])
        					return min(x, lo, mid-1);
        				else{
        					int m1 = min(x, lo, mid);
        					int m2 = min(x, mid+1, hi);
        					return Math.min(m1, m2);
        				}
        			}
        			else//Goto right side
        				return min(x, mid+1, hi);	
        		}
    	}
    }


}