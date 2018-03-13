class MatrixRotateConstantSpace {
	static final int incr[][] = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
	
	public static void main(String args[]) {
		int matrix[][] = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
		printArr(matrix);
		new MatrixRotateConstantSpace().rotate(matrix);
		System.out.println();
		printArr(matrix);
	}


	public void rotate(int matrix[][]) {
		int n = matrix.length;
		int start = 0, end = n-1;		
		while(start < end) {
			int len = end - start;
			int points[][] = {{start, start}, {start, end}, {end, end}, {end, start}};
			for(int i=0 ; i < len; i++) {
				int prev = matrix[points[3][0]][points[3][1]];
				int current;
				for(int k = 0; k < 4; k++) {
					// System.out.println("k="+k);
					current = matrix[points[k][0]][points[k][1]];
					matrix[points[k][0]][points[k][1]] = prev;
					prev = current;
				}
				updatePoints(points);	
			}
			start++;
			end--;
		}
			
	}


	private void updatePoints(int[][] points) {
		for(int i = 0 ; i < 4; i++) {
			points[i][0] += incr[i][0];
			points[i][1] += incr[i][1];
		}
	}


	private static void printArr(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0 ; i < m; i++) {
			for(int j=0; j < n; j++) {
				System.out.format("%2d%s", matrix[i][j], " ");
			}
			System.out.println();
		}
	}
}