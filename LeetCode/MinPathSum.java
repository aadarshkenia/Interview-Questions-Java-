class MinPathSum{
	public int minPathSum(int[][] grid){
		int m = grid.length;
		if(m < 1)
			return 0;
		int n = m[0].length;
		int buf[][] = new int[m][n];
		buf[0][0] = grid[0][0];
		//Initializing top row
		for(int i=1; i < n; i++){
			buf[0][i] = buf[0][i-1] + grid[0][i];
		}
		//Initializing left col
		for(int i=1; i < m; i++){
			buf[i][0] = buf[i-1][0] + grid[i][0];
		}

		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				buf[i][j] = Math.min(buf[i-1][j], buf[i][j-1]) + grid[i][j];
			}
		}

		return buf[m-1][n-1];
	}	

}
