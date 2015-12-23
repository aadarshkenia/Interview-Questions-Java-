
class CountCompleteTree{

	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		CountCompleteTree tree = new CountCompleteTree();
		int count = tree.countNodes(root);
		System.out.println(count);

	}

int countNodes(TreeNode root){
		if(root == null)
			return 0;
		if(root.left == null)
		    return 1;
		if(root.right == null)
		    return 2;
		    
		TreeNode current = root;
		int left_ht =  height(current.left);
		int right_ht = current.right == null ? 0 : height(current.right);
		System.out.println("l: "+left_ht);
		System.out.println("r: "+right_ht);


	    if(left_ht == right_ht){
	    	int temp = countNodes(root.right);
	        System.out.println("temp: "+temp+" leftcnt: "+(1<<left_ht));
	        return (1<<left_ht) + countNodes(root.right);
	    }
	    else{
	    	int temp = countNodes(root.left);
	        System.out.println("temp: "+temp+" rightcnt: "+(1<<right_ht));
	        return 1<<right_ht + countNodes(root.left);
	    }
	        
	}

	//returns height of leftmode branch of tree
	int height(TreeNode node){
		int height = 0;
		while(node != null){
			height++;
			node = node.left;
		}
		return height;
	}

}
