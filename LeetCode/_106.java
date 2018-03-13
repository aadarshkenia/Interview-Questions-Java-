class _106{

	public static void main(String[] args) {
		int p[] = {3,2,1};
		int i[] = {1,3,2};
		TreeNode root = buildTree(p, i);
		Tree tree = new Tree();
		tree.dfs(tree.root);
		System.out.println(root.val);	
	}

	public static TreeNode buildTree(int[] postorder, int[] inorder) {
		int n = postorder.length;
		return buildTreeHelper(postorder, 0, n-1, inorder, 0, n-1);
	}

	public static TreeNode buildTreeHelper(int[] postorder, int p_lo, int p_hi, int[] inorder, int i_lo, int i_hi){
		System.out.println("p_lo:"+p_lo+" p_hi:"+p_hi);
		int n = p_hi - p_lo + 1;
		if(n < 1)
			return null;
		int rootVal = postorder[p_hi];
		TreeNode root = new TreeNode(rootVal);

		int rootIndex = getRootIndex(rootVal, inorder, i_lo, i_hi);
		int leftSize = rootIndex - i_lo;
		int rightSize = i_hi - rootIndex;

		TreeNode leftSubtree = buildTreeHelper(postorder, p_lo, p_lo + leftSize - 1, inorder, i_lo, rootIndex-1);
		TreeNode rightSubtree = buildTreeHelper(postorder, p_lo + leftSize, p_hi-1,  inorder, rootIndex + 1, i_hi);
		root.left = leftSubtree;
		root.right = rightSubtree;
		return root;
	}

	public static int getRootIndex(int root, int inorder[], int lo, int hi){
		for(int i=lo; i <= hi; i++)
			if(inorder[i] == root)
				return i;
		return -1;
	}
}
