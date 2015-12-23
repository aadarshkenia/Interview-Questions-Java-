class JumpGame2{

	public static void main(String args[]){
		//Test input
		int x[] = {2,3,1,1,4};
		System.out.println(jump(x));
	}

	//DP but un-optimized, probably inner loop can be O(log n)
	public static int jump(int[] nums){
		int n = nums.length;
		int jumps[] = new int[n];
		//Filling up jumps in bottom up manner
		jumps[0] = 0;
		for(int i=1; i < n; i++){
			int min = Integer.MAX_VALUE;
			for(int j=i-1; j >= 0; j--){
				if(i <= j+nums[j])
					if(min > jumps[j] + 1)
						min = jumps[j] + 1;
			}
			jumps[i] = min;
		}
		return jumps[n-1];
	}
}
