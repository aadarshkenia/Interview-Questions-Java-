
public class Tree{
	TreeNode root = null;
	
	//Default constructor
	public Tree(){
	
	}

	public Tree(TreeNode root){
		this.root = root;
	}
	//Create tree from array
	public Tree(int x[]){
		int n = x.length;
		if(n == 0)
			return;
		TreeNode nodes[] = new TreeNode[n];
		for(int i=0; i < n; i++)
			nodes[i] = x[i] != -10 ? (new TreeNode(x[i])) : null;
		root = nodes[0];
		for(int i=0; i < n; i++){
			TreeNode curr = nodes[i];
			if(curr == null)
				continue;
			int lc = 2*i+1;
			int rc = 2*i+2;
			if(lc < n)
				curr.left = nodes[lc];
			if(rc < n)
				curr.right = nodes[rc];
		}
	}

	public void dfs(TreeNode node){
		if(node == null)
			return;
		System.out.println(node.val);

		dfs(node.left);
		dfs(node.right);
	}
}
