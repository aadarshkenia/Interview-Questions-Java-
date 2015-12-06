import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


class ReverseWords{

	public static void main(String args[]){

		ReverseWords obj = new ReverseWords();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String input = null;
		try{
			System.out.println("Enter a string: ");
			input = br.readLine();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		String output = obj.reverse(input); 
		System.out.println(output);
		System.out.println("Ans len: "+output.length());	
	}



	public String reverse(String input){

		if(input == null)
			return null;
		int len = input.length();
		StringBuilder output = new StringBuilder();
		int last_space = len;
		for(int i=len-1;i>=0;i--){
			if(input.charAt(i)==' ' || i==0){
				if(last_space == i+1 && input.charAt(i)== ' '){
					last_space = i;
					continue;
				}
				
				String current_word = "";
				if(i!=0){
					current_word = input.substring(i+1, last_space);
				}
				/*
				else{
					if(input.charAt(i)!=' ')
						current_word = input.substring(0, last_space);
					else 
						current_word = input.substring(1, last_space);
				}
				*/
				if(output.length()!=0)
					output.append(" ");
				output.append(current_word);
				last_space = i;
			} 
		}
		output.append(input.substring(0, last_space));

		return output.toString();


	}

}
