class _34 {

	public static void main(String args[]) {
		_34 instance = new _34();
		System.out.println("race --> " + instance.shortest("race"));
		System.out.println("google --> " + instance.shortest("google"));
		System.out.println("abcd --> " + instance.shortest("abcd"));
		System.out.println("aaaa --> " + instance.shortest("aaaa"));
	}

	public String shortest(String s) {
		char ch[] = s.toCharArray();
		int n = s.length();
		String buf[][] = new String[n][n];
		for(int i = 0; i < n; i++) {
			buf[i][i] = "" + ch[i];			
		}


		//DP
		for(int k=2; k <= n; k++){
			for(int i=0 ; i + k <= n; i++) {
				int j = i + k - 1;
				if(ch[i] == ch[j]) {
					if(k == 2) {
						buf[i][j] = s.substring(i, j+1);
					} else {
						buf[i][j] = ch[i] + buf[i+1][j-1] + ch[i];	
					}
					
				} else {
					String smallest = null;
					String s1 = ch[i] + buf[i+1][j] + ch[i];
					String s2 = ch[j] + buf[i][j-1] + ch[j];
					if(s1.length() < s2.length()) smallest = s1;
					else if(s1.length() == s2.length()) smallest = s1.compareTo(s2) < 0 ? s1 : s2;
					else smallest = s2;
					buf[i][j] = smallest;
				}
			}
		}
		return buf[0][n-1];
	}
}