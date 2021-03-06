class _450 {

	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;
		if(root.val == key) {
			if(root.right == null) return root.left;
			else if(root.left == null) return root.right;
			else {
				TreeNode min = findMin(root.right);
				root.val = min.val;
				root.right = deleteNode(root.right, root.val);
				return root;
			}
		} else if(root.val < key) {
			root.right = deleteNode(root.right, key);
		} else if(root.val > key) {
			root.left = deleteNode(root.left, key);
		}
		return root;
    }

    private TreeNode findMin(TreeNode root) {
		if(root.left == null) return root;
		return findMin(root.left);
    }

}




  // Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
