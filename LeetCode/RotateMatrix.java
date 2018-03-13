class RotateMatrix{

	public static void main(String args[]){
		int n = 3;
		int x[][] = new int[n][n];
		for(int i=1; i <= n*n; i++){
			int row = (i-1)/n;
			int col = (i-1)%n;

			x[row][col] = i;
		}
	
		rotate(x);

		for(int i=0; i < n; i++){
			for(int j=0; j < n; j++){
				System.out.print(x[i][j]+" ");
			}
			System.out.println();
		}

	}


	public static void rotate(int[][] matrix){
		int n = matrix.length;
		System.out.println("n="+n);
		int rs = 0, cs = 0, re = n-1, ce = n-1;


		while(rs < re){
			System.out.println("rs: "+rs+" re:"+re+" cs:"+cs+" ce:"+ce);
			int numElems = re - rs + 1;
			//Aux array storing right column
			int x[] = new int[numElems];
			for(int i = 0; i<numElems; i++){
				x[i] = matrix[re-i][ce];
			} 
			//Rotate top row
			for(int i=0; i < numElems; i++){
				matrix[re-i][ce] = matrix[rs][ce-i];
			}


			//Rotate left col
			for(int i=0; i < numElems; i++){
				matrix[rs][ce-i] = matrix[rs+i][cs];
			} 	

			//Rotate bottom row
			for(int i=0; i < numElems; i++){
				matrix[rs+i][cs] = matrix[re][cs+i];
			}

			//Rotate right col
			for(int i=0; i < numElems; i++){
				matrix[re][cs+i] = x[i];
			}

			rs++; re--;
			cs++; ce--;
		}
	}
}
