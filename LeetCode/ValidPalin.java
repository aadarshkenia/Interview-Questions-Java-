import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class ValidPalin{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try{
			str = br.readLine();
		}

	}

	public static boolean isPalindrome(String str){
		int i = 0;
		int j = str.length() - 1;
		while(i < j){
			int front = (int)str.charAt(i);
			int end = (int)str.charAt(j);
			if(front <= 48 || front >= ){
			} 
		}
	}

}
