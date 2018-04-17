import Tree.TreeNode;
class _230 {
	public int kthSmallest(TreeNode root, int k) {
        return kthSmallestUtil(root, k).smallest;
    }

    public Result kthSmallestUtil(TreeNode root, int k) {
    	//Base case.
    	if(root == null) {
    		return new Result(-1, 0);
    	}
    	Result left  = kthSmallest(root.left, k);
        Result right = kthSmallest(root.right, k - 1 - left.num);        
        int ans;
        if(left.num <= k) {
        	ans = left.smallest;
        } else if(left.num == k - 1){
        	ans = root.val;
        } else if(k <= left.num + right.num + 1){
        	ans = right.smallest;
        } else {
        	ans = -1;
        }
        return new Result(ans, left.num + 1 + right.num);
    }
}

class Result {
	int smallest,
	int num;
	Result(int smallest, int num) {
		this.smallest = smallest;
		this.num = num;
	}
}