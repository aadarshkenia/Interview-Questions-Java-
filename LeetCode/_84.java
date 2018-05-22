import java.util.Stack;
class _84 {
	public static void main(String args[]) {
		int x[] = {2,1,5,6,2,3};
		System.out.println(new _84().largestRectangleArea(x));
	}


	public int largestRectangleArea(int[] heights) {
        if(heights == null) {
        	throw new IllegalArgumentException();
        }
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int max = 0;
        for(int i=0; i < n; i++) {
        	int curr = heights[i];
        	while(!s.empty() && heights[s.peek()] >= curr) {
        		int pop = s.pop();
        		int left = s.empty() ? 0 : s.peek() + 1;
        		max = Math.max(max, heights[pop] * (i - left));
        	}
        	s.push(i);
        }
        while(!s.empty()) {
    		int pop = s.pop();
    		int left = s.empty() ? 0 : s.peek() + 1;
    		max = Math.max(max, heights[pop] * (n - left));
    	}
    	return max;
    }
}