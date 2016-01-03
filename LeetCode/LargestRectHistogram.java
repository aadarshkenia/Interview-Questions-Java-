import java.util.Stack;
class LargestRectHistogram{
	public static void main(String args[]){
		int x[] = {2,1,2};
		int ans = largestRectangleArea(x);
		System.out.println(ans);
	}

	public static int largestRectangleArea(int[] height){
		int n = height.length;
		if(n < 1)
			return 0;
		Stack<Integer> stack = new Stack();
		int max = 0;
		for(int i=0; i<n; i++){
			if(stack.empty() || height[i] > height[stack.peek()]){
				stack.push(i);
			}
			else{
				while(!stack.empty() && height[stack.peek()] > height[i]){
					int top_index = stack.pop();
					int rectArea = 0;
					if(stack.empty()){
						rectArea = i * height[top_index];
					}
					else{
						rectArea = (i - stack.peek() - 1)*height[top_index];
					}
					max = Math.max(rectArea, max);
				}
				stack.push(i);
			}
		}
		//Popping the stack out
		while(!stack.empty()){
			int top_index = stack.pop();
			int rectArea = 0;
			if(stack.empty()){
				rectArea = n * height[top_index];
			}
			else{
				rectArea = (n - stack.peek() - 1)*height[top_index];
			}
			max = Math.max(rectArea, max);
		}
		return max;
	}
}
