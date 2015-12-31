class SummaryRanges{
	public List<String> summaryRanges(int[] nums) {
    	List<String> ans = new ArrayList();
    	int n = nums.length;
    	if(n == 0)
    		return ans;
    	int start = nums[0];
    	int end = nums[0];
    	for(int i=1; i<n; i++){
    		if(nums[i] == nums[i-1] + 1){
    			end = nums[i];
    		}
    		else{
    			ans.add(createRange(start, end));
    			start = nums[i];
    			end = nums[i];
    		}
    	}
    	return ans;    
    }

    public String createRange(int s, int e){
    	if(s == e)
    		return Integer.toString(s);
    	else{
    		return s+"->"+e;
    	}

    }

}