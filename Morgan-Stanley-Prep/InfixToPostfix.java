class InfixToPostfix{

	public static void main(String args[]){
		String input = "1+2-3";
		System.out.println(getPostfixForm(input));
	
	}


	//Function converts an infix expression to postfix
	public static String getPostfixForm(String infix){
		StringBuilder output = null;
		int n = infix.length();
		int operator_ptr = 0;
		int last_op_index = -1; // index of last operator
		while(operator_ptr < n){
			if(isOperator(infix.charAt(operator_ptr))){
				if(output == null){
					output = new StringBuilder(infix.substring(0, operator_ptr));
				}
				String second_operand = getSecondOperand(infix.substring(operator_ptr+1));
				output.append(second_operand);
				output.append(infix.charAt(operator_ptr));
				operator_ptr += second_operand.length()+1;
			}
			else
				operator_ptr++;	
		}
		return output.toString();
	
	}

	//Returns true if char is an operator
	public static boolean isOperator(char c){
		if(c=='+' || c=='-')
			return true;
		return false;
	}

	public static String getSecondOperand(String s){
		if(s == null)
			return null;
	
		int i=0;
		while(i < s.length()){
			if(isOperator(s.charAt(i)))
				return s.substring(0, i);
			i++;
		}
		return s;	
	}


}
