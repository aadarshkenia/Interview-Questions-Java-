class _220{
	public static void main(String args[]){
		int x[] = {10,100,11,9};
		int t = 1, k = 2;
		System.out.println(containsNearbyAlmostDuplicate(x,k,t));

	}
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		//i-j <= k
		//nums[i] - nums[j] <= t
		int n = nums.length;
		if(n <= 1)
			return false;
		BST bst = new BST();
		//Store indices at nodes instead of values.
		bst.insert(0);
		//Simultaneous check + insert
		for(int i=1; i < n; i++){
			if(search(bst.root, nums, k, t, i))
				return true;
			else
				bst.insert(i, nums);
		}//end of for
		return false;
	}//eof

	public static boolean search(BSTNode node, int nums[], int k, int t, int currIndex){
		if(node == null)
			return false;

		long diff = Math.abs(nums[node.val] - nums[currIndex]);
		if(diff <= t){
			if(Math.abs(node.val - currIndex) <= k)
				return true;
			else
				return search(node.left, nums, k, t, currIndex) || search(node.right, nums, k, t, currIndex);				
		}
		else{
			if(nums[currIndex] > nums[node.val])
				return search(node.right, nums, k, t, currIndex);
			else
				return search(node.left, nums, k, t, currIndex);	
		}
	}	
}