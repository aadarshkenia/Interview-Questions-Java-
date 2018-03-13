class _768 {
	public static void main(String args[]) {
		int[] arr = {2,1,3,4,4};
		System.out.println("Max chunks=" + new _768().maxChunksToSorted(arr));
	}


	public int maxChunksToSorted(int[] arr) {
		int n = arr.length;
     	int dp[] = new int[n+1];
     	dp[n] = 0;
     	dp[n - 1] = 1;
          int min[] = new int[n+1];
     	min[n] = Integer.MAX_VALUE;
     	for(int i = n - 1; i >= 0; i--) {
     		min[i] = Math.min(arr[i], min[i+1]); //min[i] represents the smallest elem in the subarray arr[i...n-1]
     	}	
     	for(int i = n - 2; i >= 0; i--) {
               int max = arr[i];
               int maxChunks = 0;     		
               for(int j = i+1; j <= n; j++) {
               	if(max <= min[j]) { // Check if a valid partition can be done from arr[i....j-1] and arr[j...n-1]
               		maxChunks = Math.max(maxChunks, 1 + dp[j]);
               	}
               	if(j < n) max = Math.max(max, arr[j]); //Update max if current elem is larger.
               }
               dp[i] = maxChunks;
          }
          return dp[0];
    }
}