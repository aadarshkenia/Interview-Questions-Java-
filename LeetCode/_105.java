class _105{
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		return buildTreeHelper(preorder, 0, n-1, inorder, 0, n-1);
	}

	public TreeNode buildTreeHelper(int[] preorder, int p_lo, int p_hi, int[] inorder, int i_lo, int i_hi){
		int n = p_hi - p_lo + 1;
		if(n < 1)
			return null;
		int rootVal = preorder[p_lo];
		TreeNode root = new TreeNode(rootVal);

		int rootIndex = getRootIndex(rootVal, inorder, i_lo, i_hi);
		int leftSize = rootIndex - i_lo;
		int rightSize = i_hi - rootIndex;

		TreeNode leftSubtree = buildTreeHelper(preorder, p_lo+1, p_lo + leftSize, inorder, i_lo, rootIndex-1);
		TreeNode rightSubtree = buildTreeHelper(preorder, p_lo + leftSize+1, p_hi,  inorder, rootIndex + 1, i_hi);
		root.left = leftSubtree;
		root.right = rightSubtree;
		return root;
	}

	public int getRootIndex(int root, int inorder[], int lo, int hi){
		for(int i=lo; i <= hi; i++)
			if(inorder[i] == root)
				return i;
		return -1;
	}
}
