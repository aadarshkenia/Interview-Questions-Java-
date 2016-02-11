class ValidateBST{
	public static void main(String args[]){
		int x[] = {10,5,16,3,9};
		Tree tree = new Tree(x);
		System.out.println(isValid(tree.root));
	}

	public static boolean isValid(TreeNode root){
		return isValidHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isValidHelper(TreeNode node, int min, int max){
		if(node == null)
			return true;
		if(node.val < min || node.val > max)
			return false;
		return isValidHelper(node.left, min, node.val-1) && isValidHelper(node.right, node.val+1, max);
	}
}
