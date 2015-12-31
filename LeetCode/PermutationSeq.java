class PermutationSeq{
	static int factorials[];
	public static String getPermutation(int n, int k){
		initializeFactorials(n);
		int x[] = new int[n];
		for(int i=0; i<n; i++)
			x[i] = i+1;
		return getPermutationHelper(x, 0, n-1, k);
	}

	public static String getPermutationHelper(int x[], int start, int k){
		int len = x.length-start+1;
		if(start == n-1)
			return;
		int fact = factorials[len-1];
		if(k < fact){
			return x[start] + getPermutationHelper(x, start+1, end, k);	
		}
		else if(k == fact){
			return x[start] + concatRev(x, start+1, end);
		}
		else{
			int div = k/fact;
			swap(x, start, start+div);
			return getPermutationHelper(x, start+1, end, k%fact);
		}
	
	}
	public static void initializeFactorials(int n){
		if(n < 1)
			return;
		factorials = new int[n+1];
		factorials[0]=1;
		for(int i=1; i<=n; i++){
			factorials[i] = i * factorials[i-1];	
		}
	}

	private static void swap(int x[], int a, int b){
		x[b] = x[a] + x[b];
		x[a] = x[b] - x[a];
		x[b] = x[b] - x[a];
	}

	public static String concat(int x[], int start, int end){
		StringBuilder sb = new StringBuilder();
		for(int i=start; i<=end; i++){
			sb.append(x[i]);
		}	
		return sb.toString();
	}

	public static String concatRev(int x[], int start, int end){
		StringBuilder sb = new StringBuilder();
		for(int i=end; i>=start; i--){
			sb.append(x[i]);
		}	
		return sb.toString();
		
	}

}
