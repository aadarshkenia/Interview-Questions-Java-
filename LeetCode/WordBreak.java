import java.util.Set;
import java.util.HashSet;

class WordBreak{

	public static void main(String args[]){
		String s = "leetscode";
		String dict[] = {"leet","leets", "code"};
		Set<String> wordDict = new HashSet<String> ();
		for(String str : dict)
			wordDict.add(str);

		System.out.println(wordBreak(s, wordDict));
	}

	public static boolean wordBreak(String s, Set<String> dict){
		int n = s.length();
		boolean buf[] = new boolean[n];		
		for(int i=0;i<n;i++){
			if(dict.contains(s.substring(0, i+1)))
				buf[i] = true;
			else{
				for(int j=i-1; j>=0;j--){
					if(buf[j] == true){
						if(dict.contains(s.substring(j+1, i+1)))
							buf[i] = true;
					}
				}
			}
			//System.out.println("i: "+i+" : "+buf[i]);
		}	

		return buf[n-1];
	}//function
}