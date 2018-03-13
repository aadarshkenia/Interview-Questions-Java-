import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class _326{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(isPowerOfThree(n));
	}

	 public static boolean isPowerOfThree(int n) {
	 	int largestPow = (int)(Math.log(Integer.MAX_VALUE)/Math.log(3));
		int largest = (int)Math.pow((double)3, (double)largestPow); 
	 	System.out.println("Largest pow: "+largest);
		return n > 0 && largest%n == 0;
	 }
}
