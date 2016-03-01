import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class Addition{
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter two numbers: ");
		int a=0,b=0;
		try{
			a = Integer.parseInt(br.readLine());
			b = Integer.parseInt(br.readLine());
		}	
		catch(IOException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Ans: "+add(a, b));
	}

	public static int add(int a, int b){
		int carry = 0;
		int ans = 0;
		int count = 0;
		while(a!=0 || b!=0){
			int a_lsb = a & 1;
			int b_lsb = b & 1;
			int sum = a_lsb ^ b_lsb ^ carry;
			carry = a_lsb & b_lsb;
			System.out.println("Sum: "+sum+" carry: "+carry);
			ans = (sum<<count++) | ans;
			a = a>>1;
			b = b>>1;
		}
		if(carry == 1)
			ans = (1<<count++) | ans;
		return ans;
	}
}
