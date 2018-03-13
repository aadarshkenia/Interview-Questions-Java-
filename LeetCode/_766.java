class _766 {

	public static void main(String args[]) {
		int matrix[][] = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		boolean ans = new Solution().isToeplitzMatrix(matrix);
		System.out.println(ans);
	}



    public boolean isToeplitzMatrix(int[][] matrix) {
 		int rows = matrix.length;
 		int cols = matrix[0].length;
 		int[] top_diag = {0,0};
 		int[] bottom_diag = {0,0};        
    	while(top_diag[1] < cols || bottom_diag[0] < rows) {
    		boolean b1 = top_diag[1] < cols ? checkDiagonal(top_diag, rows, cols, matrix) : true;
    		boolean b2 = bottom_diag[0] < rows ? checkDiagonal(bottom_diag, rows, cols, matrix) : true;
    		if(!b1 || !b2) return false;
    		top_diag[1] += 1;
    		bottom_diag[0] += 1;
    	}
    	return true;
    }

    private boolean checkDiagonal(int[] diagStart, int rows, int cols, int[][] matrix) {
    	int diagLength = Math.min(cols - diagStart[1], rows - diagStart[0]);
		int elem = matrix[diagStart[0]][diagStart[1]];
		for(int i=1; i < diagLength; i++) {
			int x_new = diagStart[0] + i;
			int y_new = diagStart[1] + i;
			if(matrix[x_new][y_new] != elem) return false;
		}    	
    	return true;
    }
}