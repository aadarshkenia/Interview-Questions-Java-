import java.util.List;
import java.util.ArrayList;
class _229 {
	public List<Integer> majorityElement(int[] nums) {
		//Generalization of Moore voting algorithm.
		int candidate1 = -1, candidate2 = -2, count1 = 0, count2 = 0, n = nums.length;
		for(int x : nums) {
			if(x == candidate1) {
				count1++;
			} else if(x == candidate2) {
			  	count2++;  
			} else if(count1 == 0) {
				candidate1 = x;
				count1 = 1;
			} else if(count2 == 0) {
				candidate2 = x;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		List<Integer> ans = new ArrayList<>();
		int c1 = 0, c2 = 0;
		for(int x: nums) {
			if(x == candidate1) c1++;
			if(x == candidate2) c2++;
		}
		if(c1 > n/3) ans.add(candidate1);
		if(c2 > n/3) ans.add(candidate2);
		return ans;    
	}
}