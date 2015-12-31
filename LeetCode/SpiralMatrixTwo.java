class SpiralMatrixTwo{
	public static void main(String args[]){
		int n = Integer.parseInt(args[0]);
		int matrix[][] = generateMatrix(n);
		printMatrix(matrix);
	}

	public static void printMatrix(int[][] matrix){
		int n = matrix.length;
		for(int i=0; i < n; i++){
			for(int j=0; j < n; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int[][] generateMatrix(int n){
        int matrix[][] = new int[n][n];
        int rs = 0, re = n-1, cs = 0, ce = n-1;
        int counter=1;
        while(rs<= re && cs<= ce){
            //Top row
            for(int i=cs; i <= ce; i++){
                matrix[rs][i] = counter++;
            }

            //Right col
            for(int i=rs+1; i < re; i++){
            	matrix[i][ce] = counter++;
            }

            //Bottom row
            for(int i=ce; i >= cs && rs != re; i--){
            	matrix[re][i] = counter++;
            }

            //Left col
            for(int i=re-1; i > rs  && cs != ce; i--){
            	matrix[i][cs] = counter++;
            }

            rs++;
            re--;
            cs++;
            ce--;

        }
        return matrix;
    }
}