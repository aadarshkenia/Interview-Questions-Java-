import java.util.*;
class Solution {

		public static void main(String args[]) {
			Solution solution = new Solution();
			List<String> list = Arrays.asList("bcd", "cd", "a", "ab");
			System.out.println(solution.wordBreak("abcd", list));
		}

    	private Set<String> hash = new HashSet<>();
		public List<String> wordBreak(String s, List<String> wordDict) {
        	for(String word : wordDict) hash.add(word);
			int n =s.length();
			Object[] buffer = new Object[n+1];
			buffer[n] = Collections.emptyList();
			for(int i = n-1; i >= 0; i--) {
				List<String> ans = new ArrayList<>();
				for(int j = i+1; j <= n; j++) {
					String prefix = s.substring(i, j);					
					if(hash.contains(prefix)) {
						if(j == n) {
							ans.add(prefix);
						} else if(((List<String>)buffer[j]).size() > 0) {
							ans.addAll(createList(prefix, (List<String>)buffer[j]));
						}
						
					}
				}
				buffer[i] = ans;
			}
			return (List<String>)buffer[0];
    	}

    	private List<String> createList(String prefix, List<String> list) {
    		List<String> ans = new ArrayList<>();
    		for(String s : list) {
				ans.add(prefix + " " + s);
			}
    		return ans;
    	}
}

