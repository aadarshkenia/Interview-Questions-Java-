class _190 {
	public int reverseBits(int n) {
    	int high = n >> 16;
    	System.out.println(n);
    	int low = n & ((int)Math.pow(2.0, 16.0) - 1);   
    	return high | (low << 16);
    }

    public static void main(String args[]) {
    	System.out.println(new _190().reverseBits(43261596));
    }
}