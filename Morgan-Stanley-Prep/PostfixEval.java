import java.util.Stack;
class PostfixEval{

	public static void main(String args[]){
		String postfix = "52+3-";
		System.out.println("Ans: "+postfixEvaluate(postfix));
	}

	//Assuming operands are single digits
	public static int postfixEvaluate(String postfix){
		Stack<Integer> stack = new Stack<Integer>();
		int n = postfix.length();
		for(int i=0;i<n;i++){
			char current_char = postfix.charAt(i);
			if(isOperator(current_char)){
				int second_op = stack.pop();
				int first_op = stack.pop();
				int ans = applyOperator(first_op, second_op, current_char);
				
				if(i==n-1)
					return ans;
				else
					stack.push(ans);
			}
			else{
				stack.push(current_char - '0');
			}
		}
		return Integer.MIN_VALUE;
	}
	//Returns true if char is an operator
	public static boolean isOperator(char c){
		if(c=='+' || c=='-')
			return true;
		return false;
	}

	public static int applyOperator(int op1, int op2, char operator){
		switch(operator){
			case '+':
				return op1+op2;
			case '-':
				return op1-op2;
			case '*':
				return op1*op2;
			case '/':
				return op1/op2;
			default:
				return -1;
		}
	}

}
