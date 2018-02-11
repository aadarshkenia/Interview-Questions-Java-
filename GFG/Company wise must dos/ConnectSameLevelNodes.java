class ConnectSameLevelNodes {
	void connect(Node root) {
    	connectUtil(root, true);
    }

    private Node connectUtil(Node node, boolean callNextLevel) {
    	if(node == null) return null;    	
    	Node nl = node.left, nr = node.right, retVal = null;
   		Node successor = connectUtil(node.nextRight, false);	
		if(nl != null && nr != null) {
			nl.nextRight = nr;
			nr.nextRight = successor;
			retVal = nl;
		} else if(nl != null || nr != null) {
			Node nonNullChild = nl != null ? nl : nr;
			nonNullChild.nextRight = successor;
			retVal = nonNullChild;
		} else {
			retVal = successor;
		}
   		if(callNextLevel) {   			
			connectUtil(retVal, true);
			
   		} 
   		// System.out.println("Returning node with value: " + retVal.data);
   		return retVal;
    }    


    public static void main(String args[]) {
    	Node root = new Node(10);
    	Node n1 = new Node(20);
    	Node n2 = new Node(30);
    	Node n3 = new Node(40);
    	Node n4 = new Node(60);

    	root.left = n1;
    	root.right = n2;
    	n1.left = n3;
    	n1.right = n4;

    	new ConnectSameLevelNodes().connect(root);
    }
}


class Node {
	int data;
    Node left, right, nextRight;
    Node(int item)
    {
        data = item;
        left = right = nextRight = null;
		
    }
}