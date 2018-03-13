import java.util.List;
import java.util.ArrayList;

class SpiralOrder{

	public static void main(String args[]){
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		int matrix[][] = new int[m][n];
		for(int i=1; i<=m*n; i++){
			int r = 0, c=0;
			if(m==n){
				r = (i-1)/m;
				c = (i-1)%m;
			}
			else{
				if(m>n){
					r = (i-1)/n;
					c = (i-1)%n;
				}
				else{
					r = (i-1)/n;
					c = (i-1)%n;
				}
			}
			try{
				matrix[r][c] = i;
			}
			catch(ArrayIndexOutOfBoundsException e){
				e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println("r:"+r+" c:"+c+" i:"+i);
				return;
			}
		}
		printMatrix(matrix, m, n);
		List<Integer> so = spiralOrder(matrix);
		System.out.println(so);
	}

	public static void printMatrix(int[][] matrix, int m, int n){
		for(int i=0; i < m; i++){
			for(int j=0; j < n; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();
        int m = matrix.length;
        if(m<=0)
            return ans;
        int n = matrix[0].length;
        int counter = 0;
        int rs = 0, re = m-1, cs = 0, ce = n-1;
        int numElems = m*n;
        while(rs<= re && cs<= ce){
            //Top row
            for(int i=cs; i <= ce; i++){
                ans.add(matrix[rs][i]);
                counter++;
            }

            //Right col
            for(int i=rs+1; i < re; i++){
            	ans.add(matrix[i][ce]);
            	counter++;
            }

            //Bottom row
            for(int i=ce; i >= cs && rs != re; i--){
            	ans.add(matrix[re][i]);
            	counter++;
            }

            //Left col
            for(int i=re-1; i > rs  && cs != ce; i--){
            	ans.add(matrix[i][cs]);
            	counter++;
            }

            rs++;
            re--;
            cs++;
            ce--;

        }
        return ans;
    }
}