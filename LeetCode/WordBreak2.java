import java.util.*;

class WordBreak2{
	public static void main(String args[]){
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		HashSet<String> set = new HashSet();
		set.add("a");
		set.add("aa");
		set.add("b");
		//set.add("sand");
		//set.add("dog");

		List<String> ans = wordBreak(s, set);
		System.out.println(ans);
	}

	public static List<String> wordBreak(String s, Set<String> dict){
		List<String> result = new ArrayList<String>();
		int n = s.length();
		boolean buf[] = new boolean[n];	
		List<List<String>> bufList = new ArrayList<List<String>>();	
		for(int i=0;i<n;i++){
			List<String> sentences = new ArrayList<String>();
			if(dict.contains(s.substring(0, i+1))){
				buf[i] = true;
				sentences.add(s.substring(0, i+1));
			}
			else{
				for(int j=i-1; j>=0;j--){
					if(buf[j] == true){
						if(dict.contains(s.substring(j+1, i+1))){
							buf[i] = true;
							List<String> prevSentences = bufList.get(j);
							for(String prefix : prevSentences){
								sentences.add(prefix+" "+s.substring(j+1, i+1));
							}
						}
					}
				}
			}
			//System.out.println("i: "+i+" : "+buf[i]);
			bufList.add(i, sentences);
		}	
		return bufList.get(n-1);
	}//function

}