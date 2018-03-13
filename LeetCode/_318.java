import java.util.Arrays;
class _318 {
	public int maxProduct(String[] words) {
     	int n = words.length;
     	int masks[] = new int[n];
     	
     	Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());

     	for(int i = 0; i < n; i++) {
     		for(char c : words[i].toCharArray()) {
     			masks[i] |= 1 << (c - 'a');
     		}
     	}
     	int max = 0;
     	for(int i = 0; i < n; i++) {
     		if(words[i].length() * words[i].length() < max) break;
     		for(int j = i + 1; j < n; j++) {
     			if((masks[i] & masks[j]) == 0) {
     				if(max < words[i].length() * words[j].length()) {
     					max = words[i].length() * words[j].length();
     					break;
     				}
     			}
     		}
     	}
     	return max;
    }	
}