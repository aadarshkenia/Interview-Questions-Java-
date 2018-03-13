class _769 {

	public static void main(String args[]) {
		int x[] = {4,3,2,1,0};
		System.out.println("Ans=" + new _769().maxChunksToSorted(x));
	}

	public int maxChunksToSorted(int[] arr) {
        return maxChunks(arr, 0);
    }

    private int maxChunks(int arr[], int startIndex) {
    	// System.out.println("Start index is : " + startIndex );
    	int n = arr.length;
    	if(startIndex == n-1) return 1;
    	else if(startIndex >= n) return 0;
    	int lowest = arr[startIndex], highest = arr[startIndex];
    	for(int i = startIndex; i < n; i++) {
    		int x = arr[i];
    		highest = x > highest ? x : highest;
    		lowest = x < lowest ? x : lowest;
    		if(lowest == startIndex && highest == i)  { //Chunk can be formed from the elems arr[startIndex] to arr[i], both inclusive.
    			return 1 + maxChunks(arr, i + 1);
    		}
    	}
    	throw new RuntimeException("This should never happen.");
    }
}