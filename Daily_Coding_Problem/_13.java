//Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
class _13 {

	public static void main(String args[]) {
		_13 instance = new _13();
		System.out.println("aacdbd,2 --->" + instance.maxLen("aacdbd", 2));
		System.out.println("aacaadbaad,2 --->" + instance.maxLen("aacaadbaad", 2));
		System.out.println("abcdef,3 --->" + instance.maxLen("abcdef", 3));
		System.out.println("aaaaaa,2 --->" + instance.maxLen("aaaaaa", 2));
		System.out.println("acdeaaaa,1 --->" + instance.maxLen("acdeaaaa", 1));
	}
	
	private int maxLen(String s, int k) {
		if(k < 1) {
			return 0;
		}
		int n = s.length();
		char ch[] = s.toCharArray();
		int[] buf = new int[60];
		Arrays.fill(buf, -1);
		int max = 0, previous = 0, kcount = 1;
		buf[ch[0] - 65] = 0;
		for(int i = 1; i < n; i++) {
			char c = ch[i];
			if(buf[c - 65] == -1) { //not present in hash
				if(kcount == k) {
					//Add current char to hash and reduce the size of window by pointing prev to the correct position.
					int nxt = buf[minIdx(buf)];
					//Cleanup
					for(int j = previous; j <= nxt; j++) {
						buf[ch[j] - 65] = -1; //Remove everything between [previous, next]
					}
					previous = nxt + 1;
					//System.out.println(String.format("Current idx: %d, previous= %d", i, previous));
				} else {
					kcount++;
				} 
			}
			buf[c - 65] = i;
			//System.out.println(String.format("Current idx: %d, previous= %d", i, previous));
			max = Math.max(max, i - previous + 1);
		}
		return max;

	}

	private int minIdx(int[] buf) {
		int min = Integer.MAX_VALUE, minIdx = 0;
		for(int i=0; i < buf.length; i++) {
			if(buf[i] != -1 && buf[i] < min) {
				min = buf[i];
				minIdx = i;
			}
		}
		return minIdx;
	}
}
