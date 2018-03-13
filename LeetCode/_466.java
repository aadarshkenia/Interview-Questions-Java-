class _466 {
	
	public static void main(String args[]) {
		System.out.println(new _466().getMaxRepetitions("acb", 4, "ab", 2));
	}
 
	int s1_ptr, s2_ptr; //pointers to last unmatched characters in s1 and s2 in a sequence of repeated strings.
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		int lo = 1, hi = n1;
		s1_ptr = 0;
		s2_ptr = 0;
		double lowestRatio = Double.MAX_VALUE;
		while(lo <  hi) {
			double mid = lo + (hi-lo)/2.0;
			boolean match = (hi-lo) % 2 == 0 ? matches(s1, s2, (int)mid, 1) : matches(s1, s2, (int) (2 * mid), 2);
			if(match) {
				// System.out.println(String.format("s1_ptr:%d, s2_ptr:%d, lo:%d, hi:%d", s1_ptr, s2_ptr, lo, hi));
				// Get min ratio
				lowestRatio = Math.min(mid, lowestRatio);
				// double ratio = (double)lo + (hi-lo)/2.0; //ratio will be different for 2 s2s vs 1 s2.
				hi = (int)Math.floor(mid);
			} else {
				lo = (int)Math.ceil(mid);
			}
		}
		return lowestRatio == Double.MAX_VALUE ? 0 : (int)(n1 / (lowestRatio * n2));
	}	

	//Check if S2[s2, max2] can be obtained from S1[s1, max1] 
	private boolean matches(String s1, String s2, int max1, int max2) {
		int n1 = s1.length(), n2 = s2.length();
		while(s1_ptr < max1 * n1 && s2_ptr < max2 * n2) {
			int idx1 = s1_ptr - (s1_ptr / n1) * n1;
			int idx2 = s2_ptr - (s2_ptr / n2) * n2;
			if(s1.charAt(idx1) == s2.charAt(idx2)) {
				s2_ptr++;
			}
			s1_ptr++;
		}
		return s2_ptr == max2 * n2;
	}
}

