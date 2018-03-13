class CheckSumTree{
	public static void main(String args[]){
		
	}

	public static boolean check(TreeNode root){
		
	}

	public static Result checkHelper(TreeNode root){
		if(root == null)
			return new Result(true, 0);
		if(root.left == null && root.right == null)
			return new Result(true, root.val);

		//Check if left subtree is sumtree
		Result leftCheck = checkHelper(root.left);
		Result rightCheck = checkHelper(root.right);

		if(leftCheck.ans && rightCheck.ans)
			return new Result(true, leftCheck.sum + rightCheck.sum + root.val);
		else
			return new Reuslt(false, 0);
	}

}

class Result{
	boolean ans;
	int sum;
	Result(boolean ans, int sum){
		this.ans = ans;
		this.sum = sum;
	}

	Result(){
	
	}
}
