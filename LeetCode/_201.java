class _201 {

	public static void main(String args[]) {
		_201 instance = new _201();
		int ans = instance.rangeBitwiseAnd(0, 2147483647);
		System.out.println("Ans: " + ans);
	}

	public int rangeBitwiseAnd(int m, int n) {
    	int bits = 0;
    	long max = 2;
    	while(max <= n) {
    		max <<= 1;
    		bits++;    	
    	}
    	int ans = 0;
    	long low = (int)Math.pow(2.0, (double) bits); 
    	while(low > 0) {
    		// System.out.println("low="+low);
    		if(m >= low && n/2 < low) {
    			// System.out.println("ORing" + low + " to ans: "+ans);
    			ans |= low;
    			m-= low;
    			n-= low; 
    		}
    		low >>= 1;
    	}
    	return ans;
    }
}