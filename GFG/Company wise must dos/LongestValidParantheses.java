import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class LongestValidParantheses {
	public static void main(String args[]) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			StringBuilder ans = new StringBuilder();
			for(int i=0; i < t; i++) {
				String s = br.readLine();
				ans.append(maxValidParantheses(s));
				if(i != t-1) ans.append("\n");
			}
			System.out.println(ans.toString());	
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
		
	}

	private static int maxValidParantheses(String s) {
		int n = s.length();
		Stack<Integer> stack = new Stack<>();
		int max = 0, prevOpenBracket = -1;
		for(int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if(ch == '(') {
				stack.push(i);
			} else {
				if(!stack.isEmpty()) {
					int popIdx = stack.pop();
					int curLen = i - popIdx + 1;
					max = Math.max(curLen, max);					
					if(stack.isEmpty()) {
						int tempMax = 0;
						if(prevOpenBracket == -1){
							tempMax = i + 1;
						}
						else{
							tempMax = i - prevOpenBracket ;
						}
						max = Math.max(max, tempMax);
					}
				} else {
					prevOpenBracket = i;
				} 
			}
		}

		if(stack.isEmpty()) return max;

		int curr = n;
		while(!stack.isEmpty()) {
			int next = stack.pop();
			max = Math.max(curr - next - 1, max);
			curr = next;
		}
		return max;
	}

}