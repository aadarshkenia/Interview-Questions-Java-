import java.io.*;

class ArrayRotate{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int d = Integer.parseInt(br.readLine());
		int x[] = {1,2,3,4,5,6,7,8};

		reverse(x, d);
		System.out.println("Rotated arr: ");
		for(int i : x)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void rotate(int x[], int k){
		int n = x.length;
		for(int i=0; i < k; i++){
			
		}
	}
}
