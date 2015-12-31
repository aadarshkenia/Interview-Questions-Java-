import java.util.*;
class Subsets{
	public List<List<Integer>> subsets(int[] nums) {
     	List<List<Integer>> ans = new ArrayList();
     	int n = nums.length;
     	if(n==0)
     		return ans;
     	Arrays.sort(nums);
     	int pow = (int)Math.pow(2.0, (double)n);
     	for(int i=0; i < pow; i++){
     		String bin = Integer.toBinaryString(i);
     		List<Integer> subset = getSubsetFromBinary(bin, nums);
     		ans.add(subset);
     	}
     	return ans;	
    }

    private List<Integer> getSubsetFromBinary(String bin, int[] nums){
    	List<Integer> subset = new ArrayList();
    	int len = bin.length();
    	int n = nums.length;
    	int diff = n - len;
    	for(int i=0; i < len; i++){
    		if(bin.charAt(i) == '1')
    			subset.add(nums[diff+i]);
    	}
    	return subset;
    } 


}