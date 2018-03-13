class MinSizeSubarraySum{
	
	public static void main(String args[]){
		MinSizeSubarraySum obj = new MinSizeSubarraySum();
		int x[] = {7,1,1,1,1,6};
		int t = 7;
		System.out.println(obj.minSubArrayLen(t, x));
	}



	public int minSubArrayLen(int s, int[] nums) {
    	
		if(nums.length==0)
			return 0;

    	int n = nums.length;
    	int j=0;
    	int sums[] = getSumArray(nums);
    	int minlen=0;
    	for (int i=0; i<n; i++) {    
    		int sumElems = j==0 ? sums[i] : sums[i] - sums[j-1];   		

			if(sumElems >= s){
				while(j<=i && sumElems >= s){
					sumElems -= nums[j];
					j++;
				}
				minlen = minlen==0 ? i-j+2 : Math.min(i-j+2, minlen);
			}    		
    	}
    	return minlen;
    }

    public int[] getSumArray(int[] nums){
    	
    	int sums[] = new int[nums.length];
    	sums[0] = nums[0];
    	for(int i=1; i<nums.length; i++)
    		sums[i] = sums[i-1] + nums[i];
    	return sums;
    }
}