
class PrintBinary{
	public static void main(String args[]){

		int n = Integer.parseInt(args[0]);
		
		for(int start = 1; start<=n; start++){			
			printBinary(start);
			System.out.println();
		}

	}

	public static void printBinary(int n){
		if(n>1){
			printBinary(n/2);
		}
		System.out.print(n&1);
	}
}