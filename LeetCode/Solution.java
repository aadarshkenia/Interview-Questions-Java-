class Solution {
	public static void main(String args[]) {
		int x[] = {-3, -2, -1};
		int ans[] = squares(x);
		printArr(ans);
	}

	public static void printArr(int[] x) {
		for(int a: x)
			System.out.print(a+ " ");
	}


	public static int[] squares(int[] x) {
		int n = x.length;
		int changeOfSignIdx = 0;
		int squares[] = new int[n];
		squares[0] = x[0]*x[0];
		int ans[] = new int[n];
		for(int i=1; i < n; i++) {
			squares[i] = x[i] * x[i];
			if(x[i-1] < 0) {
				changeOfSignIdx++;
			}
		}
		int counter = 0;
		
		//Merge
		int left = changeOfSignIdx-1;
		int right = changeOfSignIdx;	
		while(left >= 0 && right < n) {
			if(squares[left] < squares[right]) {
				ans[counter++] = squares[left--];
			} else {
				ans[counter++] = squares[right++];
			}
		}

		while(left >= 0) {
			ans[counter++] = squares[left--];
		}

		while(right < n) {
			ans[counter++] = squares[right++];
		}
		
		return ans;
	}    
			
}