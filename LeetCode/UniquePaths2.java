class UniquePaths2{
	public static void main(String args[]){
		
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid){
		int m = obstacleGrid.length;
		int n=0;
		if(m > 0){
			n = obstacleGrid[0].length;
		}

		int buf[][] = new int[m][n];
		
		//Fill topmost row
		for(int i=0; i < n; i++){
			if(obstacleGrid[0][i] != 1)
				buf[0][i] = 1;
			else
				break;
		}
		//Fill leftmost col
		for(int i=0; i < m; i++){
			if(obstacleGrid[i][0] != 1)
				buf[i][0] = 1;
			else
				break;
		}

		for(int i=1; i < m; i++){
			for(int j=1; j < n; j++){
				if(obstacleGrid[i][j] != 1){
					buf[i][j] = buf[i-1][j] + buf[i][j-1];
				}
			}
		}	

		return buf[m-1][n-1];


	}
}//end of class
