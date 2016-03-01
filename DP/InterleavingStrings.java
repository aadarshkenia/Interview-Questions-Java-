import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class InterleavingStrings{
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = null;
		String b = null;
		String c = null;
		try{
			System.out.println("Enter three strings: ");
			a = br.readLine();
			b = br.readLine();
			c = br.readLine();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(isInterleave(a, b, c));
	}	

	public static boolean isInterleave(String a, String b, String c){
		int m = a.length();
		int n = b.length();
		boolean matrix[][] = new boolean[n+1][m+1];
		matrix[0][0] = true;

		//Fill top row
		for(int i=1; i <= m; i++)
			if(a.charAt(i-1) == c.charAt(i-1) && matrix[0][i-1])
				matrix[0][i] = true;

		//Fill bottom col
		for(int i=1; i <= n; i++)
			if(b.charAt(i-1) == c.charAt(i-1) && matrix[i-1][0])
				matrix[i][0] = true;

		//Fill remaining matrix
		for(int i=1; i <= n; i++){
			for(int j=1; j <= m; j++){
				char ch = c.charAt(i+j-1);
				if(ch == a.charAt(j-1))
					matrix[i][j] = matrix[i][j-1];
				if(ch == b.charAt(i-1))
					matrix[i][j] = matrix[i][j] || matrix[i-1][j];
			}
		}
		return matrix[n][m];
	}
}
