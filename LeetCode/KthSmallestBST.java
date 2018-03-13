class KthSmallestBST{
	public static void main(String args[]){
	
	}

	public int kthSmallest(TreeNode root, int k){
		int leftSubtreeSize = numNodes(root.left);
		if(leftSubtreeSize + 1 == k)
			return root.val;
		else if(k <= leftSubtreeSize)
			return kthSmallest(root.left, k);
		else
			return kthSmallest(root.right, k - leftSubtreeSize - 1);
	}

	//Function to calc number of nodes in the tree
	public int numNodes(TreeNode root){
		if(root == null)
			return 1;
		return 1 + numNodes(root.left) + numNodes(root.right);
	}

}
