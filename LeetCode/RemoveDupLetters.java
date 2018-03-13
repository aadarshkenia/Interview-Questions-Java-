import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.HashSet;
import java.util.HashMap;

class RemoveDupLetters{
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try{
			s = br.readLine();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(removeDuplicateLetters(s));
	}

	public static String removeDuplicateLetters(String s){
		Stack<Character> stack = new Stack();
		HashSet<Character> incl = new HashSet();
		HashMap<Character, Integer> right = new HashMap();
		int n = s.length();
		int uniqueChars = 0;

		//Store rightmost indices
		for(int i= 0; i < n; i++)
			right.put(s.charAt(i), i);


		for(int i=0; i < n; i++){
			char c = s.charAt(i);
			//System.out.println("Current char: "+c);
			if(incl.contains(c))
				continue;

			if(!stack.empty() && stack.peek() > c){
				//System.out.println("here");
				while(!stack.empty() && stack.peek() > c && right.get(stack.peek()) > i){
					char poppedElem = stack.pop();
					incl.remove(poppedElem);
					//System.out.println("Popping: "+poppedElem);
					uniqueChars--;
				}
			}	
			stack.push(c);
			incl.add(c);
			uniqueChars++;
		}
		//Create string from stack contents
		char ans[] = new char[uniqueChars];
		while(!stack.empty())
			ans[--uniqueChars]  = stack.pop();
		return new String(ans);
	}

}//end of class
