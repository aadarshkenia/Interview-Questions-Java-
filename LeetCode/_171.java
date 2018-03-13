class _171 {
	public int titleToNumber(String s) {
    	int ans = 0, n = s.length(), multiplier = 1;
    	for(int i = n - 1; i >= 0; i--) {
    		ans += (s.charAt(i) - 64) * multiplier;
    		multiplier *= 26;
    	}
    	return ans;
    }
}