class BST{
	public BSTNode root;
	BST(){
		root = null;
	}

	public void insert(int val){
		BSTNode newnode = new BSTNode(val);
		if(root == null)
			root = newnode;
		else{
			BSTNode temp = root;
			while(true){
				if(newnode.val <= temp.val){
					if(temp.left == null){
						temp.left = newnode;
						break;	
					}
					else
						temp = temp.left;
				}
				else{
					if(temp.right == null){
						temp.right = newnode;
						break;
					}
					else
						temp = temp.right;
				}
			}
		}
	}

}

class BSTNode{
	int val;
	BSTNode left;
	BSTNode right;

	BSTNode(int val){
		this.val = val;
	}

	BSTNode(){
		
	}
}
