public class ConnectNodesAtSameLevel {
	void connect(Node root) {
        if(root == null) return;
        Node nxConnector = findLeftmostChildOfSuccessor(root);
        if(root.left != null) {
        	root.left.nextRight = root.right != null ? root.right : nxConnector;
        }

        if(root.right != null) {
        	root.right = nxConnector;
        }

        
    }

	Node findLeftmostChildOfSuccessor(Node node) {
		Node nx = node.nextRight;
		while(nx != null) {
			if(nx.left != null || nx.right != null) {
				return nx.left != null ? nx.left : nx.right;
			} 
			nx = nx.nextRight;
		}
		return null;
	}
}

class Node
{
    int data;
    Node left, right, nextRight;
    Node(int item)
    {
        data = item;
        left = right = nextRight = null;
		
    }
}