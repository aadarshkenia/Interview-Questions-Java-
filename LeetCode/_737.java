import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

class _737 {

	public static void main(String args[]) {
		String[] w1 = {"great","acting","skills"};
		String[] w2 = {"fine","drama","talent"};
		String pairs[][] = {{"great","good"},{"fine","good"},{"drama","acting"},{"skills","talent"}};
		System.out.println(new _737().areSentencesSimilarTwo(w1, w2, pairs));
	}

	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
     	Map<String, Set<String>> map = new HashMap<>();
     	int len1 = words1.length;
     	int len2 = words2.length;
     	if(len1 != len2) return false;
     	initializeMap(map, pairs);
     	System.out.println(map);
     	for(int i=0 ; i < len1; i++) {
     		String word1 = words1[i];
     		String word2 = words2[i];
     		if(!(map.containsKey(word1) && map.get(word1).contains(word2))) return false;
     	}
     	return true;
    
    }

    private void initializeMap(Map<String, Set<String>> map, String[][] pairs) {
    	for(String[] pair : pairs) {
    		String word1 = pair[0];
    		String word2 = pair[1];
    		addSimilarWords(map, word1, word2);
    	}
    
    }

    private void addSimilarWords(Map<String, Set<String>> map, String w1, String w2) {
    	Set<String> s1 = map.getOrDefault(w1, new HashSet<>());
    	Set<String> s2 = map.getOrDefault(w2, new HashSet<>());
    	//Merged set -> set of all similar words = s1 + s2 + w1 + w2;
    	s1.addAll(s2);
    	s2 = null; //GC
    	s1.add(w1);
    	s1.add(w2);
    	for(String w : s1) map.put(w, s1);    		
	}


}