
public class Tree{
	TreeNode root = null;
	Tree(TreeNode root){
		this.root = root;
	}

	//Create tree from array
	public Tree(int x[]){
		int n = x.length;
		if(n == 0)
			return;
		TreeNode nodes[] = new TreeNode[n];
		nodes[0] = new TreeNode(x[0]);
		root = nodes[0];
		for(int i=0; i < n; i++){
			TreeNode curr = nodes[i];
			int lc = 2*i+1;
			int rc = 2*i+2;
			TreeNode leftChild = null, rightChild = null;
			if(lc<n){
				leftChild = new TreeNode(x[lc]);
				nodes[lc] = leftChild;
			}
			if(rc < n){
				rightChild = new TreeNode(x[rc]);
				nodes[rc] = rightChild;	
			}
			curr.left = leftChild;
			curr.right = rightChild;
		}
	}

	public void dfs(TreeNode node){
		if(node == null)
			return;
		System.out.println(node.val);

		if(node.left != null)
			dfs(node.left);
		if(node.right != null)
			dfs(node.right);
	}
}
