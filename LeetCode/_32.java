import java.util.Stack;
class _32{
	
	public int longestValidParentheses(String s) {
		int n = s.length();
		Stack<Integer> stack = new Stack();
		if(n <= 1)
			return 0;
		int buf[] = new int[n];
		for(int i=0; i < n; i++){
			char c = s.charAt(i);
			if(i == 0){
				if(c == '(')
					stack.push(i);
				buf[i] = 0;
			}
			else{
				if(c == ')'){
					int popIndex = stack.pop();
					buf[i] = i - popIndex + 1;
					if(popIndex != 0 && s.charAt(popIndex-1)==')')
						buf[i] += buf[popIndex-1];
				}
				else{
					stack.push(i);
					buf[i] = 0;
				}
			}
		}
		return buf[n-1];			
	}
	        
}
			

	//Int power of 4 or not.
	//Design Questions: Game of life, MS word.
	//Debug an API.
