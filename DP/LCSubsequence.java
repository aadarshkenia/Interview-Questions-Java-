class LCSubsequence{
	public static void main(String args[]){
		String s1 = "eackdgb";
		String s2 = "fckapgb";
		System.out.println(lcs(s1, s2));
	}
	

	public static String lcs(String x, String y){
		int n = x.length();
		int m = y.length();
		
		if(m==0 || n==0)
			return null;

		int buf[][] = new int[n+1][m+1];
		for(int i=1; i <= n; i++){
			for(int j=1; j <= m; j++){
				if(x.charAt(i-1) == y.charAt(j-1))
					buf[i][j] = buf[i-1][j-1]+1;
				else
					buf[i][j] = Math.max(buf[i-1][j], buf[i][j-1]);
			}
		}
		int lcsLen = buf[n][m];
		System.out.println("LCS Length: "+lcsLen);
		
		//Retreiving lcs string from buffer
		return lcsLen!=0 ? retrieveString(x,y,buf) : null;
	}

	public static String retrieveString(String x, String y, int[][] buf){
		int n = x.length();
		int m = y.length();
		
		StringBuilder ans = new StringBuilder();
		int len = buf[n][m];
		int row = n, col = m;
		while(len != 0){
			if(x.charAt(row-1) == y.charAt(col-1)){
				ans.append(x.charAt(row-1));
				len--;
				row--; 
				col--;
			}
			else{
				if(buf[row-1][col] > buf[row][col-1])
					row--;
				else
					col--;
			}
		}
		return ans.reverse().toString();
	}
}
