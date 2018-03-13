import java.util.*;

class _30{

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		List<Integer> ans = findSubstring(s, words);
		System.out.println(ans);
	}


	public static List<Integer> findSubstring(String s, String[] words) {
     	int n = s.length();
     	List<Integer> ans = new ArrayList();
 		if(words.length == 0)
 			return ans;
     	
     	HashMap<String, Integer> wordsHash = getWordsHash(words);
     	int wordLen = words[0].length();
     	int k = wordLen*words.length;
     	for(int i=0; i <= n-k; i++){
     		String substr = s.substring(i, i+k);
     		HashMap<String, Integer> newhash = copyHash(wordsHash);
     		if(check(newhash, substr, wordLen))
     			ans.add(i);
     	}   
     	return ans;
    }

    public static HashMap<String, Integer> getWordsHash(String[] words){
     	HashMap<String, Integer> allWords = new HashMap();
     	for(String word : words){
     		if(allWords.containsKey(word))
     			allWords.put(word, allWords.get(word) + 1);
     		else
     			allWords.put(word, 1);
     	}
     	return allWords;
    }

    public static HashMap<String, Integer> copyHash(HashMap<String, Integer> orig){
    	Iterator it = orig.entrySet().iterator();
    	HashMap<String, Integer> newhash = new HashMap();
	    while (it.hasNext()){
	        Map.Entry pair = (Map.Entry)it.next();
	        newhash.put((String)pair.getKey(), (Integer)pair.getValue());
	    }
	    return newhash;
    }

    public static boolean check(HashMap<String, Integer> words, String str, int wordLen){
    	int n = str.length();
    	int i = 0;
    	while(i < n){
    		String substr = str.substring(i, i+wordLen);
    		if(!words.containsKey(substr))
    			return false;
    		else{
    			int val = words.get(substr);
    			if(val == 0)
    				return false;
    			else
    				words.put(substr, val-1);
    		}
    		i += wordLen;
    	}
    	//Check buckets
    	Iterator it = words.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if(pair.getValue() != 0)
	        	return false;
	    }
	    return true;    	
    }
}