import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class SubsetSum{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x[] = {2,3,4,5,12,34};
		int sum = Integer.parseInt(br.readLine());
		System.out.println(existsSum(sum, x));
	}

	private static boolean existsSum(int sum, int x[]){
		//DP based solution
		int n = x.length;
		boolean buf[][] = new boolean[sum+1][n];
		
		//Fill topmost row
		for(int i=0; i < n; i++)
			buf[0][i] = true; 

		for(int i=1; i <= sum; i++){
			for(int j=0; j < n; j++){
				if(j==0)
					buf[i][j] = x[j] == i;
				else{
					int diff = i - x[j];
					if(diff >=0)
						buf[i][j] = buf[i][j-1] || buf[diff][j-1];
					else
						buf[i][j] = buf[i][j-1];
				}
			}
		}
		//printBu(buf, sum+1, n);
		return buf[sum][n-1];
	}

	private static void printBuf(boolean buf[][], int r, int c){
		for(int i=0; i < r; i++){
			for(int j=0; j < c; j++)
				System.out.print(buf[i][j]+" ");
			System.out.println();
		}
	}
}
