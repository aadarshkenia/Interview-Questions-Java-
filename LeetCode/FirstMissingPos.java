class FirstMissingPos{

	public static void main(String args[]){
		int x[] = {1,1};//test input
		System.out.println(firstMissingPositive(x));
	}


	public static int firstMissingPositive(int[] nums){
		int n = nums.length;
		for(int i=0; i < n; i++){
			while(nums[i] > 0 && nums[i] <= n && (nums[nums[i]-1] != nums[i])){
				swap(nums, nums[i]-1, i);
			}
		}
		for(int i=0; i<n; i++){
			if(nums[i] != i+1)
				return i+1;
		}
		return n+1;
	}

	public static void swap(int[] nums, int x, int y){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}
