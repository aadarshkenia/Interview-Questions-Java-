import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class LongestValidParantheses{
	public static void main(String args[]){
		BufferedReader br = null;
		String input;
		try{
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a string: ");
			input = br.readLine();
			System.out.println(longestValidParans(input));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public static int longestValidParans(String str){
		if(str == null)
			return 0;
		int n = str.length();
		int global_max=0;
		int curr_max = 0;
		int peo

		for(int i=0; i<n; i++){
			if(str.charAt(i) == '(')
				stack.push(str.charAt(i));
			else{
				if(!stack.empty()){
					stack.pop();
					pop_count++;
					//Update
					if(stack.empty()){
						curr_max = curr_max + 2*pop_count;
						if(curr_max > global_max)
							global_max = curr_max;
						pop_count=0;

					}
				}
				else{
					clearStack(stack);
					curr_max =0 ;
					pop_count =0;
				}
			}
		}
		return global_max;
	}

	public static void clearStack(Stack<Character> stack){
		while(!stack.empty())
			stack.pop();
	}



	public static int longestValidParansAliter(String str){
		Stack<Integer> stack = new Stack<Integer>();
		
	}
}