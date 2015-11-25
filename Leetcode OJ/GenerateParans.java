import java.util.ArrayList;
class GenerateParans{
	public static void main(String args[]){
		int n = 3;
		ArrayList<String> ans = generateParantheses(n, 0, n, n);
		System.out.println(ans);
	}

	public static ArrayList<String> generateParantheses(int n, int pos, int open, int close){
		
		ArrayList<String> result = new ArrayList<String>();
		if(pos == 2*n-1)
			result.add(")");
		else{
			if(open > 0){
				ArrayList<String> childList = generateParantheses(n, pos+1, open-1, close);
				for(String childPattern : childList){
					result.add("(" + childPattern);
				}
			}
			if(open < close){
				ArrayList<String> childList2 = generateParantheses(n, pos+1, open, close-1);
				for(String childPattern2 : childList2){
					result.add(")" + childPattern2);
				}
			}	
		}
		return result;		
	}	
}