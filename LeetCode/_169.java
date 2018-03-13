class _169 {
	private static final int NUM_BITS_IN_INTEGER = 32;
	public int majorityElement(int[] nums) {
		int n =  nums.length;
		int ans = 0;
     	for(int i=0; i < NUM_BITS_IN_INTEGER; i++) {
     		int counter = 0;
 			for(int j=0; j < n; j++) {
 				if(((nums[j] >> i) & 1) == 1) counter++; 				
 			}
 			if(counter > n/2) ans = ans | (1 << i);
     	}   
     	return ans;
    }

    public static void main(String args[]) {
    	int x[] = {1,3,2,2,1,2,2};
    	System.out.println(new _169().majorityElement(x));
    }
}