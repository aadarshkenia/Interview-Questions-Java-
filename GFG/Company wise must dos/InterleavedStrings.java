class InterleavedStrings {
	public boolean isInterLeave(String a,String b,String c)	{
        //Your code here
		int n1 = a.length();
		int n2 = b.length();
		int n3 = n1 + n2;
		boolean buf[][] = new boolean[n1+1][n2+1];	
		buf[n2][n1] = true;
		for(int i=n1 - 1; i >= 0; i--) {
			buf[n2][i] = buf[n2][i+1] && a.charAt(i) == c.charAt();
		}
	}
}