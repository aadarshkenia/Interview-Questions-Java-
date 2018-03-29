import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution2 {

	public static void main(String args[]) {
		int x[] = {1,2,3};
		System.out.println(getMin(x));
		int y[] = {10,11,0};
		System.out.println(getMin(y));
		int z[] = {1,3,22,1,3,4};
		System.out.println(getMin(z));
	}

	public static List<Integer> getMin(int x[]) {
		int n = x.length;
		int max[] = new int[n];
		int pointers[] = new int[n];
		if(n < 2) return Arrays.asList(x[0]);
		max[n-1] = x[n-1];
		max[n-2] = x[n-2];
		pointers[n-1] = -1;
		pointers[n-2] = -1;
		for(int i = n - 3; i >= 0; i--) {
			int maxVal = Integer.MIN_VALUE;
			if(x[i] + max[i+2] > maxVal) {
				maxVal = x[i] + max[i+2];
				pointers[i] = i + 2;
			} 
			if(i+3 < n && x[i] + max[i+3] > maxVal) {
				maxVal = x[i] + max[i+3];
				pointers[i] = i+3;
			}
			max[i] = maxVal;
		}
		int startIdx = max[0] > max[1] ? 0 : 1;
		List<Integer> ans = new ArrayList<>();
		while(startIdx != -1) {
			ans.add(x[startIdx]);
			startIdx = pointers[startIdx];
		}
		return ans;
	}

}